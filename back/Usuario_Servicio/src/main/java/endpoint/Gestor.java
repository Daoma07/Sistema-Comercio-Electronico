/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package endpoint;

import facade.FacadeMessageDispatcher;
import facade.IFacadeMessageDispatcher;
import negocio.implementaciones.UsuarioNegocio;
import negocio.interfaces.IUsuarioNegocio;

/**
 *
 * @author Daniel
 */
public class Gestor {

    private IUsuarioNegocio usuarioNegocio;
    private IFacadeMessageDispatcher facadeMessageDispatcher;

    public Gestor() {
        this.usuarioNegocio = new UsuarioNegocio();
        this.facadeMessageDispatcher = new FacadeMessageDispatcher();
    }

    // Registrar los manejadores
    private void registrarManejadores() {
        this.manejadoresUsuario();

    }

    private void manejadoresUsuario() {
        facadeMessageDispatcher.dispatch("login", usuarioNegocio::Login);
    }
}
