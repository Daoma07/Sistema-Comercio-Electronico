package negocio.fabrica;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import negocio.implementaciones.UsuarioNegocio;
import negocio.interfaces.IUsuarioNegocio;

public class FabricaNegocio implements IFabricaNegocio {

    private IFabricaDAO fabricaDAO;

    public FabricaNegocio() {
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public IUsuarioNegocio crearUsuarioNegocio() {
        return new UsuarioNegocio(fabricaDAO);
    }

}
