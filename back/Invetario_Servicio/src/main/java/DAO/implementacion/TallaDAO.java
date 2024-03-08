package dao.implementacion;

import conexionBD.IConexionBD;
import dominio.Talla;
import DAO.interfaces.ITallaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class TallaDAO implements ITallaDAO {

    private EntityManagerFactory entityManagerFactory;

    public TallaDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnectionMySQL();
    }

    @Override
    public Talla crearTalla(Talla talla) throws PersistenceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(talla);
            entityManager.getTransaction().commit();
            return talla;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear la talla: ya existe una talla con los mismos valores", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear la talla", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actaualizarTalla(Talla talla) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(talla);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar la talla", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Talla consulltarTallaID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Talla talla = entityManager.find(Talla.class, id);
            if (talla == null) {
                throw new EntityNotFoundException("Talla no encontrada con ID: " + id);
            }
            return talla;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarTalla(Talla talla) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(talla) ? talla : entityManager.merge(talla));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la talla", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Talla> obtenerTodasTallas() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t  FROM Talla t", Talla.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todas las tallas", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
