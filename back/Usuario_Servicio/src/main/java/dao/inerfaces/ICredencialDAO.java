package dao.inerfaces;

import dominio.Credencial;
import java.util.List;

public interface ICredencialDAO {

    Credencial crearCredencial(Credencial credencial);

    boolean actualizarCredencial(Credencial credencial);

    Credencial consultarCredencialID(Long id);

    boolean eliminarCredencial(Credencial credencial);

    List<Credencial> obtenerTodosCredencial();

}
