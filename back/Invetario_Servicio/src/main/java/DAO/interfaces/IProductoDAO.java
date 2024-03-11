package DAO.interfaces;

import dominio.Producto;
import java.util.List;

public interface IProductoDAO {
    
    Producto crearProducto(Producto producto);
    
    boolean actualizarProducto(Producto producto);
    
    Producto consultarProductoID(Long id);
    
    boolean eliminarProducto(Producto producto);
    
    List<Producto> obtenerTodosProductos();
    
}
