
package goorderpersistencia;

import BaseDatos.ConexionMongoDB;
import DTOSPersistencia.DatosReporteEntrada;
import Entidades.EntradaProducto;
import Interfaces.IBaseMongoDAO;
import Interfaces.IEntradaProductoDAO;
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
public class EntradaProductoMongoDAO implements IEntradaProductoDAO, IBaseMongoDAO {

    private static final Logger LOGGER = Logger.getLogger(EntradaProductoMongoDAO.class.getName());
    private static final String NOMBRE_COLLECTION = "EntradaProducto";

    @Override
    public EntradaProducto nuevaEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<EntradaProducto> collection = this.obtenerCollection(dataBase);
            
            collection.insertOne(entradaProducto);
            return entradaProducto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al persistir.", e);
        }
    }

    @Override
    public List<EntradaProducto> listarEntradasProductos() throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<EntradaProducto> collection = this.obtenerCollection(dataBase);
            
            FindIterable<EntradaProducto> iterable = collection.find();
            MongoCursor<EntradaProducto> cursor = iterable.cursor();
            List<EntradaProducto> listaResult = new ArrayList<>();
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
    public List<DatosReporteEntrada> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        List<DatosReporteEntrada> resultados = new ArrayList<>();
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<EntradaProducto> collection = this.obtenerCollection(dataBase);
            
            if (fechaInicio != null && fechaFin != null) {
                Date inicioPeriodo = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date finalPeriodo = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
                List<Bson> pipeline = new ArrayList<>();

                //Aplanado del arreglo del registro de la entrada
                pipeline.add(Aggregates.unwind("$registroEntrada"));
                
                //Seleccion de los campos despues del aplando del arreglo
                pipeline.add(Aggregates.project(Projections.fields( 
                        Projections.computed("idProducto", "$registroEntrada.idProducto"),
                        Projections.computed("nombre", "$registroEntrada.nombre"),
                        Projections.computed("cantidad", "$registroEntrada.cantidad"),
                        Projections.computed("precio", "$registroEntrada.precio"),
                        Projections.computed("fechaHoraOperacion", "$registroEntrada.fechaHoraOperacion")
                )));
                
                //Match que aplica a los filtros de fechas especificados.
                pipeline.add(Aggregates.match(
                        Filters.and(
                                Filters.gte("fechaHoraOperacion", inicioPeriodo),
                                Filters.lte("fechaHoraOperacion", finalPeriodo)
                        )
                ));
                collection.aggregate(pipeline, DatosReporteEntrada.class).into(resultados);
            }
          return resultados;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al listar productos de la base de datos.", e);
        }
    }
    
    //-------------------------------------------------------------------------------------------------

    @Override
    public MongoDatabase obtenerDataBase(MongoClient client) {
        MongoDatabase dataBase = client.getDatabase(ConexionMongoDB.DATA_BASE).withCodecRegistry(ConexionMongoDB.obtenerCodec());
        return dataBase;
    }

    @Override
    public MongoCollection obtenerCollection(MongoDatabase dataBase) {
        MongoCollection<EntradaProducto> collection = dataBase.getCollection(NOMBRE_COLLECTION, EntradaProducto.class);
        return collection;
    }    
}