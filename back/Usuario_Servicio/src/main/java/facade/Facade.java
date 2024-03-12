package facade;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import facade.implementacion.FacadeCredencial;
import facade.implementacion.FacadeDestinatario;
import facade.implementacion.FacadeDireccion;
import facade.implementacion.FacadeUsuario;
import facade.interfaces.IFacadeCredencial;
import facade.interfaces.IFacadeDestinatario;
import facade.interfaces.IFacadeDireccion;
import facade.interfaces.IFacadeUsuario;

public class Facade implements IFacade {

    private IFabricaDAO fabricaDAO;

    public Facade() {
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public IFacadeCredencial useFacadeCredencial() {
        return new FacadeCredencial(fabricaDAO);
    }

    @Override
    public IFacadeDestinatario useFacadeDestinatario() {
        return new FacadeDestinatario(fabricaDAO);
    }

    @Override
    public IFacadeDireccion useFacadeDireccion() {
        return new FacadeDireccion(fabricaDAO);
    }

    @Override
    public IFacadeUsuario useFacadeUsuario() {
        return new FacadeUsuario(fabricaDAO);
    }

}
