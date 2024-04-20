package facade;

import negocio.fabrica.IFabricaNegocio;

public class Facade implements IFacade {

    private IFabricaNegocio fabricaNegocio;

    public Facade(IFabricaNegocio fabricaNegocio) {
        this.fabricaNegocio = fabricaNegocio;
    }

    @Override
    public String loginUsuario(String messageConten) {
        return fabricaNegocio.crearUsuarioNegocio().loginUsuario(messageConten);
    }

    @Override
    public String registarUsuario(String messageContent) {
        return fabricaNegocio.crearUsuarioNegocio().registarUsuario(messageContent);
    }

}
