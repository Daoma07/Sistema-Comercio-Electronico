package dao.implementacion;

import conexionBD.IConexionBD;
import dao.inerfaces.ICredencialDAO;
import dominio.Credencial;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class CredencialDAO implements ICredencialDAO {

    private EntityManagerFactory entityManagerFactory;

    public CredencialDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnection();
    }

    @Override
    public Credencial crearCredencial(Credencial credencial) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(credencial);
            entityManager.getTransaction().commit();
            return credencial;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear el usuario: ya existe un usuario con el mismo correo", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear la credencial", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarCredencial(Credencial credencial) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(credencial);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar la credencial", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Credencial consultarCredencialID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Credencial credencial = entityManager.find(Credencial.class, id);
            if (credencial == null) {
                throw new EntityNotFoundException("Credencial no encontrada con ID: " + id);
            }
            return credencial;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarCredencial(Credencial credencial) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(credencial) ? credencial : entityManager.merge(credencial));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la credencial", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Credencial> obtenerTodosCredencial() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT c FROM Credencial c", Credencial.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todas las credenciales", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
