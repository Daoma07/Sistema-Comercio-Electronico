package DAO.interfaces;

import dominio.Carrito;
import java.util.List;

public interface ICarritoDAO {

    Carrito crearCarrito(Carrito carrito);

    boolean actualizarCarrito(Carrito carrito);

    Carrito consultarCarritoID(Long id);

    boolean eliminarCarrito(Carrito carrito);

    List<Carrito> obtenerTodosCarrito();

}
