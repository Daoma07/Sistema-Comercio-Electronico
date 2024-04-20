package facade.interfaces;

import dominio.Categoria;
import java.util.List;
import javax.persistence.PersistenceException;

public interface IFacadeCategoria {
    
    Categoria crearCategoria(Categoria categoria) throws PersistenceException;
    
    boolean actualizarCategoria(Categoria categoria);
    
    Categoria consultarCategoriaID(Long id);
    
    boolean eliminarCategoria(Categoria categoria);
    
    List<Categoria> obtenerTodasCategorias();
}
