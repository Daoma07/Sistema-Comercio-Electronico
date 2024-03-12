package dao.implementacion;

import conexionBD.IConexionBD;
import dao.inerfaces.IDestinatarioDAO;
import dominio.Credencial;
import dominio.Destinatario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class DestinatarioDAO implements IDestinatarioDAO {

    private EntityManagerFactory entityManagerFactory;

    public DestinatarioDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnection();
    }

    @Override
    public Destinatario crearDestinatario(Destinatario destinatario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(destinatario);
            entityManager.getTransaction().commit();
            return destinatario;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear el destinatario", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarDestinatario(Destinatario destinatario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(destinatario);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar el destinatario", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Destinatario consultarDestinatarioID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Destinatario destintario = entityManager.find(Destinatario.class, id);
            if (destintario == null) {
                throw new EntityNotFoundException("Destinatario no encontrado con ID: " + id);
            }
            return destintario;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarDestinatario(Destinatario destinatario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(destinatario) ? destinatario : entityManager.merge(destinatario));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar el destinatario", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Destinatario> obtenerTodosDestinatario() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT d FROM Destinatario d", Destinatario.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todas los destinatarios", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
