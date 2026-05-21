
package goorderpersistencia;

import BaseDatos.ConexionMongoDB;
import DTOSPersistencia.DatosReporteSalida;
import Entidades.SalidaProducto;
import Interfaces.IBaseMongoDAO;
import Interfaces.ISalidaProductoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

/**
 *
 * @author 
 */
public class SalidaProductoMongoDAO implements ISalidaProductoDAO, IBaseMongoDAO {

    private static final Logger LOGGER = Logger.getLogger(SalidaProductoMongoDAO.class.getName());   
    private static final String NOMBRE_COLLECTION = "SalidaProducto";
    
    @Override
    public SalidaProducto nuevaSalidaProducto(SalidaProducto salidaProducto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<SalidaProducto> collection = this.obtenerCollection(dataBase);
            
            collection.insertOne(salidaProducto);
            return salidaProducto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al persistir.", e);
        } 
    }

    @Override
    public List<SalidaProducto> listarSalidaProductos() throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<SalidaProducto> collection = this.obtenerCollection(dataBase);
            
            FindIterable<SalidaProducto> iterable = collection.find();
            MongoCursor<SalidaProducto> cursor = iterable.cursor();
            List<SalidaProducto> listaResult = new ArrayList<>();
            while (cursor.hasNext()) {
                listaResult.add(cursor.next());
            }
            return listaResult;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al listar productos de la base de datos.", e);
        }   
    }

    @Override
    public List<DatosReporteSalida> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        List<DatosReporteSalida> resultados = new ArrayList<>();
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<SalidaProducto> collection = this.obtenerCollection(dataBase);
            
            if (fechaInicio != null && fechaFin != null) {
                Date inicioPeriodo = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date finalPeriodo = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
                List<Bson> pipeline = new ArrayList<>();

                //Aplanado del arreglo del registro de la entrada
                pipeline.add(Aggregates.unwind("$registroSalida"));
                
                //Seleccion de los campos despues del aplando del arreglo
                pipeline.add(Aggregates.project(Projections.fields( 
                        Projections.computed("idProducto", "$registroSalida.idProducto"),
                        Projections.computed("nombre", "$registroSalida.nombre"),
                        Projections.computed("cantidad", "$registroSalida.cantidad"),
                        Projections.computed("fechaHoraOperacion", "$registroSalida.fechaHoraOperacion")
                )));
                
                //Match que aplica a los filtros de fechas especificados.
                pipeline.add(Aggregates.match(
                        Filters.and(
                                Filters.gte("fechaHoraOperacion", inicioPeriodo),
                                Filters.lte("fechaHoraOperacion", finalPeriodo)
                        )
                ));
                collection.aggregate(pipeline, DatosReporteSalida.class).into(resultados);
            }
          return resultados;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al listar productos de la base de datos.", e);
        }
    }
    
    //-----------------------------------------------------------------------------------------------------

    @Override
    public MongoDatabase obtenerDataBase(MongoClient client) {
        MongoDatabase dataBase = client.getDatabase(ConexionMongoDB.DATA_BASE).withCodecRegistry(ConexionMongoDB.obtenerCodec());
        return dataBase;
    }

    @Override
    public MongoCollection obtenerCollection(MongoDatabase dataBase) {
        MongoCollection<SalidaProducto> collection = dataBase.getCollection(NOMBRE_COLLECTION, SalidaProducto.class);
        return collection;
    }      
}