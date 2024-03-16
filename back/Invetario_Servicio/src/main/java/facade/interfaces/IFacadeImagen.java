package facade.interfaces;

import dominio.Imagen;
import java.util.List;
import javax.persistence.PersistenceException;

public interface IFacadeImagen {
    
    Imagen crearImagen(Imagen imagen) throws PersistenceException;
    
    boolean actualizarImagen(Imagen imagen);
    
    Imagen consultarImagenID(Long id);
    
    boolean eliminarImagen(Imagen imagen);
    
    List<Imagen> obtenerTodasImagens();
}
