package DAO.implementacion;

import DAO.interfaces.IProducto_TallaDAO;
import conexionBD.IConexionBD;
import dominio.Producto_Talla;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class Producto_TallaDAO implements IProducto_TallaDAO {

    private EntityManagerFactory entityManagerFactory;

    public Producto_TallaDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnectionMySQL();
    }

    @Override
    public Producto_Talla crearProducto_Talla(Producto_Talla producto_talla) throws PersistenceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(producto_talla);
            entityManager.getTransaction().commit();
            return producto_talla;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear la talla producto: ya existe una talla producto con los mismo valores", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear la talla producto", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarProducto_Talla(Producto_Talla producto_talla) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(producto_talla);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar la talla producto", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Producto_Talla consultarProducto_TallaID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Producto_Talla producto_talla = entityManager.find(Producto_Talla.class, id);
            if (producto_talla == null) {
                throw new EntityNotFoundException("Talla producto no encontrada con ID: " + id);
            }
            return producto_talla;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarProducto_Talla(Producto_Talla producto_talla) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(producto_talla) ? producto_talla : entityManager.merge(producto_talla));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la talla producto", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Producto_Talla> obtenerTodosProducto_Talla() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t FROM producto_talla p", Producto_Talla.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar todas las tallas productos", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
