package negocio.implementaciones;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.fabrica.IFabricaDAO;
import dominio.Credencial;
import dominio.Usuario;
import herraminetas.formato.FormatoJson;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.interfaces.IUsuarioNegocio;

public class UsuarioNegocio implements IUsuarioNegocio {

    private final IFabricaDAO fabricaDAO;
    private final ObjectMapper objectMapper;
    private final FormatoJson formatoJson;

    public UsuarioNegocio(IFabricaDAO fabricaDAO) {
        this.fabricaDAO = fabricaDAO;
        this.objectMapper = new ObjectMapper();
        this.formatoJson = new FormatoJson();

    }

    @Override
    public String registarUsuario(String mensaje) {

        Usuario usuario = formatoJson.convertirJsonCliente(mensaje);
        Long id = fabricaDAO.crearUsuarioDAO().crearUsuario(usuario).getId_usuario();
        if (id != null) {
            return new FormatoJson().crearJsonRespuesta("Usuario creado con éxito", id.toString());
        }
        return new FormatoJson().crearJsonRespuesta("Error al registrar usuario", null);

    }

    @Override
    public String loginUsuario(String mensaje) {
        try {
            List<Usuario> usuarios = fabricaDAO.crearUsuarioDAO().obtenerTodosUsuario();
            if (!usuarios.isEmpty()) {
                Credencial credencial = formatoJson.extrerCredenciales(mensaje);
                for (Usuario usuario : usuarios) {
                    if (usuario.getCredencial().validarCredencial(credencial)) {
                        return formatoJson.crearJsonRespuesta("Inicio de sesión exitoso", usuario.getId_usuario().toString());
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formatoJson.crearJsonRespuesta("Inicio de sesión fallido", null);
    }
}
