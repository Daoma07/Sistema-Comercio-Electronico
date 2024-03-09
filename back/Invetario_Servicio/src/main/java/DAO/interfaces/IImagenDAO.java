
package DAO.interfaces;
import dominio.Imagen;
import java.util.List;


public interface IImagenDAO 
{
    Imagen crearImagen(Imagen imagen);
    
    boolean actualizarImagen(Imagen imagen);
    
    Imagen consultarImagenID(Long id);
    
    boolean eliminarImagen(Imagen imagen);
    
    List<Imagen> obtenerTodasTallas();
    
    
}
