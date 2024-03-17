/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dominio.Usuario;
import facade.FacadeMessageDispatcher;
import facade.IFacadeMessageDispatcher;
import negocio.implementaciones.UsuarioNegocio;

/**
 *
 * @author Daniel
 */
public class Gestor {

    private UsuarioNegocio usuarioNegocio;
    private IFacadeMessageDispatcher facadeMessageDispatcher;
    private ObjectMapper objectMapper;

    public Gestor() {
        this.usuarioNegocio = new UsuarioNegocio();
        this.facadeMessageDispatcher = new FacadeMessageDispatcher();
        objectMapper = new ObjectMapper();
        this.registrarManejadores();
    }

    // Registrar los manejadores
    private void registrarManejadores() {
        this.manejadoresUsuario();

    }

    private void manejadoresUsuario() {
        facadeMessageDispatcher.registerHandler("login", usuarioNegocio::login);
    }

    public void getMessage(String correlationId, String message) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(message);
        // Acceder a las propiedades del JSON
        String action = jsonNode.get("action").asText();
        facadeMessageDispatcher.dispatch(action, message);
    }
}
