package facade.interfaces;

import dominio.Producto;
import java.util.List;
import javax.persistence.PersistenceException;

public interface IFacadeProducto {
    
    Producto crearProducto(Producto producto) throws PersistenceException;
    
    boolean actualizarProducto(Producto producto);
    
    Producto consultarProductoID(Long id);
    
    boolean eliminarProducto(Producto producto);
    
    List<Producto> obtenerTodosProductos();
}
