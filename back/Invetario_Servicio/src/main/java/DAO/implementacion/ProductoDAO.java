package DAO.implementacion;

import DAO.interfaces.IProductoDAO;
import conexionBD.IConexionBD;
import dominio.Producto;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class ProductoDAO implements IProductoDAO {

    private EntityManagerFactory entityManagerFactory;

    public ProductoDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnectionMySQL();
    }

    @Override
    public Producto crearProducto(Producto producto) throws PersistenceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
            return producto;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear el producto: ya existe un producto con los mismo valores", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear el producto", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar el producto", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Producto consultarProductoID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Producto producto = entityManager.find(Producto.class, id);
            if (producto == null) {
                throw new EntityNotFoundException("Producto no encontrado con ID: " + id);
            }
            return producto;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarProducto(Producto producto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(producto) ? producto : entityManager.merge(producto));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar el producto", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            return entityManager.createQuery("SELECT t FROM productos p", Producto.class).getResultList();
        }catch(PersistenceException e){
            throw new PersistenceException("Error al consultar todos los productos", e);
        }finally{
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}