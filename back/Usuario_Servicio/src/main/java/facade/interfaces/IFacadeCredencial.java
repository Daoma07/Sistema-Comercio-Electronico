package facade.interfaces;

import dominio.Credencial;
import java.util.List;

public interface IFacadeCredencial {

    Credencial crearCredencial(Credencial credencial);

    boolean actualizarCredencial(Credencial credencial);

    Credencial consultarCredencialID(Long id);

    boolean eliminarCredencial(Credencial credencial);

    List<Credencial> obtenerTodosCredencial();
}
