package dao.implementacion;

import conexionBD.IConexionBD;
import dao.inerfaces.IDireccionDAO;
import dominio.Credencial;
import dominio.Direccion;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class DireccionDAO implements IDireccionDAO {

    private EntityManagerFactory entityManagerFactory;

    public DireccionDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnection();
    }

    @Override
    public Direccion crearDireccion(Direccion direccion) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(direccion);
            entityManager.getTransaction().commit();
            return direccion;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear la direccion", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarDireccion(Direccion direccion) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(direccion);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar la direccion", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Direccion consultarDireccionID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Direccion direccion = entityManager.find(Direccion.class, id);
            if (direccion == null) {
                throw new EntityNotFoundException("Direccion no encontrada con ID: " + id);
            }
            return direccion;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarDireccion(Direccion direccion) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(direccion) ? direccion : entityManager.merge(direccion));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la direccion", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Direccion> obtenerTodosDestinatario() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT d FROM Direccion d", Direccion.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todas las direcciones", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
