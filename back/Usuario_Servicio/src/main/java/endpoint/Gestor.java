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
import java.util.logging.Level;
import java.util.logging.Logger;
import messageDispatcher.MessageHandler;
import negocio.implementaciones.UsuarioNegocio;

/**
 *
 * @author Daniel
 */
public class Gestor {

    private UsuarioNegocio usuarioNegocio;
    private IFacadeMessageDispatcher facadeMessageDispatcher;
    private ObjectMapper objectMapper;
    private MensajeSender mensajeSender;

    public Gestor() {
        this.usuarioNegocio = new UsuarioNegocio();
        this.facadeMessageDispatcher = new FacadeMessageDispatcher();
        objectMapper = new ObjectMapper();
        this.registrarManejadores();
        this.mensajeSender = new MensajeSender();
    }

    // Registrar los manejadores
    private void registrarManejadores() {
        this.manejadoresUsuario();

    }

    private void manejadoresUsuario() {
        facadeMessageDispatcher.registerHandler("login", usuarioNegocio::login);
        facadeMessageDispatcher.registerHandler("registrar", usuarioNegocio::registrar);
    }

    public void manejarMensaje(String correlationId, String mensaje) throws JsonProcessingException {
        try {
            //Primero procesa el mensaje
            String mensajeProcesado = procesarMensaje(mensaje);
            System.out.println(mensajeProcesado);
            //Despues lo envia
            enviarMensaje(correlationId, mensajeProcesado);
        } catch (Exception ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String procesarMensaje(String message) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(message);
        // Acceder a las propiedades del JSON
        String action = jsonNode.get("action").asText();
        String handler = facadeMessageDispatcher.dispatch(action, message);

        return handler;

    }

    private void enviarMensaje(String correlationId, String mensajeProcesado) throws Exception {
        mensajeSender.enviarMensaje(correlationId, mensajeProcesado);
    }
}
