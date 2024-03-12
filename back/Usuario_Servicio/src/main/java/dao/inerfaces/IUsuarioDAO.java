package dao.inerfaces;

import dominio.Usuario;
import java.util.List;

public interface IUsuarioDAO {

    Usuario crearUsuario(Usuario usuario);

    boolean actualizarUsuario(Usuario usuario);

    Usuario consultarUsuarioID(Long id);

    boolean eliminarUsuario(Usuario usuario);

    List<Usuario> obtenerTodosUsuario();
}
