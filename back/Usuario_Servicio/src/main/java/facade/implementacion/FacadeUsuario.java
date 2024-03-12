package facade.implementacion;

import dao.fabrica.IFabricaDAO;
import dao.inerfaces.IUsuarioDAO;
import dominio.Usuario;
import facade.interfaces.IFacadeUsuario;
import java.util.List;

public class FacadeUsuario implements IFacadeUsuario {

    private IUsuarioDAO usuarioDAO;

    public FacadeUsuario(IFabricaDAO fabricaDAO) {
        this.usuarioDAO = fabricaDAO.crearUsuarioDAO();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioDAO.crearUsuario(usuario);
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioDAO.actualizarUsuario(usuario);
    }

    @Override
    public Usuario consultarUsuarioID(Long id) {
        return usuarioDAO.consultarUsuarioID(id);
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        return usuarioDAO.eliminarUsuario(usuario);
    }

    @Override
    public List<Usuario> obtenerTodosUsuario() {
        return usuarioDAO.obtenerTodosUsuario();
    }

}
