package DAO.interfaces;

import dominio.Talla;
import java.util.List;

public interface ITallaDAO {

    Talla crearTalla(Talla talla);

    boolean actaualizarTalla(Talla talla);

    Talla consulltarTallaID(Long id);

    boolean eliminarTalla(Talla talla);

    List<Talla> obtenerTodasTallas();

}
