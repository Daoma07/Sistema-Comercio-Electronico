package DAO.implementacion;

import DAO.interfaces.IImagenDAO;
import conexionBD.IConexionBD;
import dominio.Imagen;
import dominio.Talla;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class ImagenDAO implements IImagenDAO
{
    private EntityManagerFactory entityManagerFactory;
    
    public ImagenDAO (IConexionBD conexionBD) throws SQLException 
    {
        this.entityManagerFactory = conexionBD.useConnectionMySQL();
    }


    @Override
    public Imagen crearImagen(Imagen imagen) throws PersistenceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(imagen);
            entityManager.getTransaction().commit();
            return imagen;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear la imágen: ya existe una imágen con los mismos valores", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear la imágen", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    @Override
    public boolean actualizarImagen(Imagen imagen) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(imagen);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar la imágen", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Imagen consultarImagenID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Imagen imagen = entityManager.find(Imagen.class, id);
            if (imagen == null) {
                throw new EntityNotFoundException("Imágen no encontrada con ID: " + id);
            }
            return imagen;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarImagen(Imagen imagen) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(imagen) ? imagen : entityManager.merge(imagen));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la imágen", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Imagen> obtenerTodasTallas() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t  FROM imagenes i", Imagen.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todas las imágenes", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    
}
