/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import dominio.Usuario;
import facade.Facade;
import facade.IFacade;
import java.util.List;
import negocio.interfaces.IUsuarioNegocio;

/**
 *
 * @author Daniel
 */
public class UsuarioNegocio implements IUsuarioNegocio {

    IFacade facade;

    public UsuarioNegocio() {
        this.facade = new Facade();
    }

    public Usuario Login(String contenido) {
//        List<Usuario> usuarios = facade.useFacadeUsuario().obtenerTodosUsuario();
//        Usuario usuarioEncontrado;
//        for (int i = 0; i < usuarios.size(); i++) {
//            if (usuarios.get(i).getCredencial().validarCredencial(correo, contrasenia)) {
//                return usuarioEncontrado = usuarios.get(i);
//            }
//        }
        return null;
    }

}
