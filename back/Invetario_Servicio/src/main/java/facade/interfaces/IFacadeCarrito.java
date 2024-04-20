package facade.interfaces;

import dominio.Carrito;
import java.util.List;
import javax.persistence.PersistenceException;

public interface IFacadeCarrito {
    
    Carrito crearCarrito(Carrito carrito) throws PersistenceException;
    
    boolean actualizarCarrito(Carrito carrito);
    
    Carrito consultarCarritoID(Long id);
    
    boolean eliminarCarrito(Carrito carrito);
    
    List<Carrito> obtenerTodosCarritos();
}
