
package goorderpersistencia;

import BaseDatos.ConexionMongoDB;
import Entidades.Producto;
import Interfaces.IBaseMongoDAO;
import Interfaces.IInventarioDAO;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author maild
 */
public class InventarioMongoDAO implements IInventarioDAO, IBaseMongoDAO {

    private static final Logger LOGGER = Logger.getLogger(InventarioMongoDAO.class.getName());
    private static final String NOMBRE_COLLECTION = "Producto";

    //Como no es mapeada, se usa la collection de productos o ...???
    
    @Override
    public List<Producto> obtenerListaProductos() throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            FindIterable<Producto> iterable = collection.find();
            MongoCursor<Producto> cursor = iterable.cursor();
            List<Producto> listaResult = new ArrayList<>();
            
            while (cursor.hasNext()) {
                listaResult.add(cursor.next());
            }            
            return listaResult;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al consultar productos de inventario.");
        }
    }

    @Override
    public List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException {
        List<Producto> resultados = new ArrayList<>();
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            List<Bson> filtros = new ArrayList<>();
            if (nombre != null && !nombre.trim().isEmpty()) {
                filtros.add(Filters.regex("nombre", nombre, "i"));
            }
            if (cantidad != null) {
                filtros.add(Filters.gte("cantidad", cantidad));
            }
            Bson filtroFinal = filtros.isEmpty() ? new Document() : Filters.and(filtros);
            collection.find(filtroFinal).into(resultados);
            return resultados;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al consultar productos de inventario.");
        }
    }

    @Override
    public Producto agregarProducto(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);            
            
            collection.insertOne(producto);
            return producto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al agregar producto al inventario.");
        }
    }

    @Override
    public Producto actualizarSumarProductoInventario(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            Bson filtro = Filters.eq("_id", producto.getId());
            Bson operacion = Updates.inc("cantidad", producto.getCantidad());
            Producto actualizar = collection.findOneAndUpdate(filtro, operacion);
            if (actualizar == null) {
                throw new PersistenciaException("No existe producto para incrementar cantidad.");
            }
            return producto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al consultar productos de inventario.");
        }
    }

    @Override
    public Producto actualizarRestarProductoInventario(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            
            Bson filtro = Filters.eq("_id", producto.getId());
            int cantidadRestar = producto.getCantidad() * -1;
            Bson operacion = Updates.inc("cantidad", cantidadRestar);
            Producto actualizar = collection.findOneAndUpdate(filtro, operacion);
            if (actualizar == null) {
                throw new PersistenciaException("No existe producto para decrementar cantidad.");
            }
            return producto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al consultar productos de inventario.");
        }
    }
    
    //---------------------------------------------------------------------

    @Override
    public MongoDatabase obtenerDataBase(MongoClient client) {
        MongoDatabase dataBase = client.getDatabase(ConexionMongoDB.DATA_BASE).withCodecRegistry(ConexionMongoDB.obtenerCodec());
        return dataBase;
    }

    @Override
    public MongoCollection obtenerCollection(MongoDatabase dataBase) {
        MongoCollection<Producto> collection = dataBase.getCollection(NOMBRE_COLLECTION, Producto.class);
        return collection;
    }
}