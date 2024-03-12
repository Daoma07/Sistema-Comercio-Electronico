package facade;

import facade.interfaces.IFacadeCredencial;
import facade.interfaces.IFacadeDestinatario;
import facade.interfaces.IFacadeDireccion;
import facade.interfaces.IFacadeUsuario;

public interface IFacade {

    IFacadeCredencial useFacadeCredencial();

    IFacadeDestinatario useFacadeDestinatario();

    IFacadeDireccion useFacadeDireccion();

    IFacadeUsuario useFacadeUsuario();
}
