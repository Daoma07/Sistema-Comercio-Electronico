package DAO.interfaces;

import dominio.Talla;
import java.util.List;

public interface ITallaDAO {

    Talla crearTalla(Talla talla);

    boolean actualizarTalla(Talla talla);

    Talla consultarTallaID(Long id);

    boolean eliminarTalla(Talla talla);

    List<Talla> obtenerTodasTallas();

}
