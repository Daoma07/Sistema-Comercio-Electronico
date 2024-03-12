package facade.interfaces;

import dominio.Usuario;
import java.util.List;

public interface IFacadeUsuario {

    Usuario crearUsuario(Usuario usuario);

    boolean actualizarUsuario(Usuario usuario);

    Usuario consultarUsuarioID(Long id);

    boolean eliminarUsuario(Usuario usuario);

    List<Usuario> obtenerTodosUsuario();

}
