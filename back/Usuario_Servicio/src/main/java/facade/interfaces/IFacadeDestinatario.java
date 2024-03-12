package facade.interfaces;

import dominio.Destinatario;
import java.util.List;

public interface IFacadeDestinatario {

    Destinatario crearDestinatario(Destinatario destinatario);

    boolean actualizarDestinatario(Destinatario destinatario);

    Destinatario consultarDestinatarioID(Long id);

    boolean eliminarDestinatario(Destinatario destinatario);

    List<Destinatario> obtenerTodosDestinatario();

}
