/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static dominio.Credencial_.contrasenia;
import dominio.Usuario;
import endpoint.MensajeSender;
import facade.Facade;
import facade.IFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class UsuarioNegocio {

    private IFacade facade;
    private ObjectMapper objectMapper;
    private MensajeSender mensajeSender;

    public UsuarioNegocio() {
        this.facade = new Facade();
        this.objectMapper = new ObjectMapper();
        this.mensajeSender = new MensajeSender();
    }

    public Usuario login(String messageContent) {
        try {
            List<Usuario> usuarios = facade.useFacadeUsuario().obtenerTodosUsuario();

            JsonNode jsonNode = objectMapper.readTree(messageContent);

            String correo = jsonNode.get("correo").asText();
            String contrasenia = jsonNode.get("contrasenia").asText();
            for (Usuario usuario : usuarios) {
                // Verifica si el usuario es válido, por ejemplo, utilizando la lógica de validación de credenciales
                if (usuario.getCredencial().validarCredencial(correo, contrasenia)) {
                    System.out.println(usuario.toString());

                    String id = jsonNode.get("correlationId").asText();
                    /////////////////////////////////////////////////////
                    ObjectMapper objectMapper = new ObjectMapper();

                    // Crear un ObjectNode para representar el JSON
                    ObjectNode jsonRespuesta = objectMapper.createObjectNode();

                    // Agregar campos al JSON
                    jsonRespuesta.put("nombre", "John");
                    jsonRespuesta.put("apellido", "Doe");
                    jsonRespuesta.put("edad", 30);

                    // Convertir ObjectNode a una cadena JSON
                    String jsonString = objectMapper.writeValueAsString(jsonRespuesta);
                    mensajeSender.enviarMensaje(id, jsonString);
                    return usuario; // Devuelve el usuario si se encuentra un usuario válido
                }
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
