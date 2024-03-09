
package DAO.interfaces;

import dominio.Estilo;
import java.util.List;


public interface IEstiloDAO {
    
    Estilo crearEstilo(Estilo estilo);

    boolean actualizarEstilo(Estilo estilo);

    Estilo consultarEstiloID(Long id);

    boolean eliminarEstilo(Estilo estilo);

    List<Estilo> obtenerTodosEstilos();
    
}
