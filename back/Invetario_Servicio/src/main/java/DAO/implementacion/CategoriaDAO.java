/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.implementacion;

import DAO.interfaces.ICategoriaDAO;
import conexionBD.IConexionBD;
import dominio.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

public class CategoriaDAO implements ICategoriaDAO {

    private EntityManagerFactory entityManagerFactory;

    public CategoriaDAO(IConexionBD conexionBD) throws SQLException {
        this.entityManagerFactory = conexionBD.useConnectionMySQL();
    }

    @Override
    public Categoria crearCategoria(Categoria categoria)throws PersistenceException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(categoria);
            entityManager.getTransaction().commit();
            return categoria;
        } catch (PersistenceException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new PersistenceException("Error al crear la categoría: ya existe una categoría con los mismos valores", e);
            }
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al crear la categoría", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean actualizarCategoria(Categoria categoria) {
               EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(categoria);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al actualizar la categoría", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Categoria consultarCategoriaID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Categoria categoria = entityManager.find(Categoria.class, id);
            if (categoria == null) {
                throw new EntityNotFoundException("Categoría no encontrada con ID: " + id);
            }
            return categoria;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean eliminarCategoria(Categoria categoria) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(categoria) ? categoria : entityManager.merge(categoria));
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error al eliminar la categoría", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Categoria> obtenerTodasCategorias() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t  FROM categorias c", Categoria.class).getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al obtener todas las categorías", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    
}
