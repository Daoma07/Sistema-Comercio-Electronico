package DAO.interfaces;

import dominio.Producto_Talla;
import java.util.List;

public interface IProducto_TallaDAO {
    
    Producto_Talla crearProducto_Talla(Producto_Talla producto_talla);
    
    boolean actualizarProducto_Talla(Producto_Talla producto_talla);
    
    Producto_Talla consultarProducto_TallaID(Long id);
    
    boolean eliminarProducto_Talla(Producto_Talla producto_talla);
    
    List<Producto_Talla> obtenerTodosProducto_Talla();
    
}
