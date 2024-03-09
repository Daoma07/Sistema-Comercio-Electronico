/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.implementacion;

import DAO.interfaces.IEstiloDAO;
import conexionBD.IConexionBD;
import dominio.Estilo;
import dominio.Imagen;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class EstiloDAO implements IEstiloDAO {

    private EntityManagerFactory entityManagerFactory;

    public EstiloDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnectionMySQL();
    }

    @Override
    public Estilo crearEstilo(Estilo estilo) throws PersistenceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(estilo);
            entityManager.getTransaction().commit();
            return estilo;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear el estilo: ya existe un estilo con los mismos valores", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear el estilo", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarEstilo(Estilo estilo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(estilo);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar el estilo", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Estilo consultarEstiloID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Estilo estilo = entityManager.find(Estilo.class, id);
            if (estilo == null) {
                throw new EntityNotFoundException("Estilo no encontrada con ID: " + id);
            }
            return estilo;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarEstilo(Estilo estilo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(estilo) ? estilo : entityManager.merge(estilo));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar el estilo", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Estilo> obtenerTodosEstilos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t  FROM estilos i", Estilo.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todos los estilos", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    
    
    
}
