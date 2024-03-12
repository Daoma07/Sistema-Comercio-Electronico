package dao.inerfaces;

import dominio.Direccion;
import java.util.List;

public interface IDireccionDAO {

    Direccion crearDireccion(Direccion direccion);

    boolean actualizarDireccion(Direccion direccion);

    Direccion consultarDireccionID(Long id);

    boolean eliminarDireccion(Direccion direccion);

    List<Direccion> obtenerTodosDestinatario();

}
