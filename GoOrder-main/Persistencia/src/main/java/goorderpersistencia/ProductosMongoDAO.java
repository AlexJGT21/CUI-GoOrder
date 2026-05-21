
package goorderpersistencia;

import BaseDatos.ConexionMongoDB;
import Entidades.Producto;
import Interfaces.IBaseMongoDAO;
import Interfaces.IProductoDAO;
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
import org.bson.conversions.Bson;

/**
 *
 * @author
 */
public class ProductosMongoDAO implements IProductoDAO, IBaseMongoDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductosMongoDAO.class.getName());    
    private static final String NOMBRE_COLLECTION = "Producto";

    @Override
    public Producto crearProducto(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            collection.insertOne(producto);
            return producto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al persistir entidad.", e);
        }
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            Bson filtro = Filters.eq("_id", producto.getId());
            Bson update = Updates.set("cantidad", producto.getCantidad());
            collection.updateOne(filtro, update);
            return producto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al actualizar producto.", e);
        }
    }

    @Override
    public Producto eliminarProducto(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            Bson filtro = Filters.eq("_id", producto.getId());
            collection.deleteOne(filtro);
            return producto;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al borrar registro", e);
        }
    }

    @Override
    public List<Producto> obtenerProducto(String nombreProducto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            Bson filtro = Filters.regex("nombre", nombreProducto, "i");
            FindIterable<Producto> iterable = collection.find(filtro);
            MongoCursor<Producto> cursor = iterable.cursor();
            List<Producto> listaResult = new ArrayList<>();
            
            while (cursor.hasNext()) {
                listaResult.add(cursor.next());
            }            
            return listaResult;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al obtener producto.", e);
        }
    }

    @Override
    public List<Producto> listarProductos() throws PersistenciaException {
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
            throw new PersistenciaException("Error al obtener productos.", e);
        }
    }

    @Override
    public List<Producto> buscarProducto(String nombreProducto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            Bson filtro = Filters.regex("nombre", nombreProducto, "i");
            FindIterable<Producto> iterable = collection.find(filtro);
            MongoCursor<Producto> cursor = iterable.cursor();
            List<Producto> listaResult = new ArrayList<>();
            
            while (cursor.hasNext()) {
                listaResult.add(cursor.next());
            }            
            return listaResult;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al obtener producto.", e);
        }
    } 
    
    @Override
    public Producto obtenerProductoPorId(Producto producto) throws PersistenciaException {
        try (MongoClient client = ConexionMongoDB.crearConexion()){
            MongoDatabase dataBase = this.obtenerDataBase(client);
            MongoCollection<Producto> collection = this.obtenerCollection(dataBase);
            
            Bson filtro = Filters.eq("_id", producto.getId());
            Producto existe = collection.find(filtro).first();
            return existe;
        } catch (MongoException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al buscar producto en la base de datos.");
        }
    }
    
    //-----------------------------------------------------------------------

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
