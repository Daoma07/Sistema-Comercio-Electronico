package facade.implementacion;

import dao.fabrica.IFabricaDAO;
import dao.inerfaces.IDestinatarioDAO;
import dominio.Destinatario;
import facade.interfaces.IFacadeDestinatario;
import java.util.List;

public class FacadeDestinatario implements IFacadeDestinatario {

    private IDestinatarioDAO destinatarioDAO;

    public FacadeDestinatario(IFabricaDAO fabricaDAO) {
        this.destinatarioDAO = fabricaDAO.crearDestinatarioDAO();
    }

    @Override
    public Destinatario crearDestinatario(Destinatario destinatario) {
        return destinatarioDAO.crearDestinatario(destinatario);
    }

    @Override
    public boolean actualizarDestinatario(Destinatario destinatario) {
        return destinatarioDAO.actualizarDestinatario(destinatario);
    }

    @Override
    public Destinatario consultarDestinatarioID(Long id) {
        return destinatarioDAO.consultarDestinatarioID(id);
    }

    @Override
    public boolean eliminarDestinatario(Destinatario destinatario) {
        return destinatarioDAO.eliminarDestinatario(destinatario);
    }

    @Override
    public List<Destinatario> obtenerTodosDestinatario() {
        return destinatarioDAO.obtenerTodosDestinatario();
    }

}
