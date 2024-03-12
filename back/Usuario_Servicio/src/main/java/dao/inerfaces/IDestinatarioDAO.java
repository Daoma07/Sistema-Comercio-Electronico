package dao.inerfaces;

import dominio.Destinatario;
import java.util.List;

public interface IDestinatarioDAO {

    Destinatario crearDestinatario(Destinatario destinatario);

    boolean actualizarDestinatario(Destinatario destinatario);

    Destinatario consultarDestinatarioID(Long id);

    boolean eliminarDestinatario(Destinatario destinatario);

    List<Destinatario> obtenerTodosDestinatario();
}
