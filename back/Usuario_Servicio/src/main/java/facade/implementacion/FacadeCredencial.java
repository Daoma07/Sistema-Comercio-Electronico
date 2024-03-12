package facade.implementacion;

import dao.fabrica.IFabricaDAO;
import dao.inerfaces.ICredencialDAO;
import dominio.Credencial;
import facade.interfaces.IFacadeCredencial;
import java.util.List;

public class FacadeCredencial implements IFacadeCredencial {

    private ICredencialDAO credencialDAO;

    public FacadeCredencial(IFabricaDAO fabricaDAO) {
        this.credencialDAO = fabricaDAO.crearCredencialDAO();
    }

    @Override
    public Credencial crearCredencial(Credencial credencial) {
        return credencialDAO.crearCredencial(credencial);
    }

    @Override
    public boolean actualizarCredencial(Credencial credencial) {
        return credencialDAO.actualizarCredencial(credencial);
    }

    @Override
    public Credencial consultarCredencialID(Long id) {
        return credencialDAO.consultarCredencialID(id);
    }

    @Override
    public boolean eliminarCredencial(Credencial credencial) {
        return credencialDAO.eliminarCredencial(credencial);
    }

    @Override
    public List<Credencial> obtenerTodosCredencial() {
        return credencialDAO.obtenerTodosCredencial();
    }

}
