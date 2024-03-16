package facade.interfaces;

import dominio.Producto_Talla;
import java.util.List;
import javax.persistence.PersistenceException;

public interface IFacadeProducto_Talla {
    
    Producto_Talla crearProductoTalla(Producto_Talla producto_talla) throws PersistenceException;
    
    boolean actualizarProductoTalla(Producto_Talla producto_talla);
    
    Producto_Talla consultarProductoTallaID(Long id);
    
    boolean eliminarProductoTalla(Producto_Talla producto_talla);
    
    List<Producto_Talla> obtenerTodosProductosTalla();
}
