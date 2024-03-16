package facade.interfaces;

import dominio.Estilo;
import java.util.List;
import javax.persistence.PersistenceException;

public interface IFacadeEstilo {
    
    Estilo crearEstilo(Estilo estilo) throws PersistenceException;
    
    boolean actualizarEstilo(Estilo estilo);
    
    Estilo consultarEstiloID(Long id);
    
    boolean eliminarEstilo(Estilo estilo);
    
    List<Estilo> obtenerTodosEstilos();
}
