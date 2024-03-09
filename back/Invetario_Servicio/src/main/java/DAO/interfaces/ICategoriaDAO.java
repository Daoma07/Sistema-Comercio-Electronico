
package DAO.interfaces;

import dominio.Categoria;
import java.util.List;


public interface ICategoriaDAO {
        
    Categoria crearCategoria(Categoria categoria);

    boolean actualizarCategoria(Categoria categoria);

    Categoria consultarCategoriaID(Long id);

    boolean eliminarCategoria(Categoria categoria);

    List<Categoria> obtenerTodasCategorias();
    
}
