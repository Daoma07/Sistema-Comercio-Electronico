/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dominio.Credencial;
import static dominio.Credencial_.contrasenia;
import static dominio.Destinatario_.direccion;
import dominio.Direccion;
import dominio.Genero;
import dominio.TipoUsuario;
import dominio.Usuario;
import endpoint.MensajeSender;
import facade.Facade;
import facade.IFacade;
import java.util.ArrayList;
import java.util.Date;
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
        this.objectMapper = new ObjectMapper();
    }

    public String registrar(String messageContent) {

        try {
            JsonNode jsonNode = objectMapper.readTree(messageContent);
            String nombres = jsonNode.get("nombres").asText();
            String apellido_paterno = jsonNode.get("apellido_paterno").asText();
            String apellido_materno = jsonNode.get("apellido_materno").asText();
            String telefono = jsonNode.get("telefono").asText();
            String fechaNacimiento = jsonNode.get("fecha_nacimienti").asText();
            String sexo = jsonNode.get("sexo").asText().toLowerCase();
            Genero genero = null;
            if (sexo.equals("hombre")) {
                genero = Genero.MASCULINO;
            } else if (sexo.equals("mujer")) {
                genero = Genero.FEMENINO;
            }

            String correo = jsonNode.get("correo").asText();
            String contrasenia = jsonNode.get("password").asText();

            String calle = jsonNode.get("calle").asText();
            String numero = jsonNode.get("numero").asText();
            String colonia = jsonNode.get("colonia").asText();
            String ciudad = jsonNode.get("ciudad").asText();
            String estado = jsonNode.get("estado").asText();
            String codigo_postal = jsonNode.get("codigo_postal").asText();

            Credencial credencial = new Credencial(correo, contrasenia);

            List<Direccion> direcciones = new ArrayList<>();
            Direccion direccion = new Direccion(calle, numero, colonia, ciudad, estado, codigo_postal);
            direcciones.add(direccion);
            Usuario usuario = new Usuario(nombres, apellido_paterno,
                    apellido_materno, telefono, new Date(fechaNacimiento),
                    genero, TipoUsuario.CLIENTE, credencial, direcciones);

            Long id = facade.useFacadeUsuario().crearUsuario(usuario).getId_usuario();

            ObjectNode jsonRespuesta = objectMapper.createObjectNode();

            // Agregar campos al JSON
            jsonRespuesta.put("msg", "usuario creado con exito");
            jsonRespuesta.put("id", id.toString());

            String jsonString = objectMapper.writeValueAsString(jsonRespuesta);

            return jsonString;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String login(String messageContent) {
        try {
            List<Usuario> usuarios = facade.useFacadeUsuario().obtenerTodosUsuario();
            JsonNode jsonNode = objectMapper.readTree(messageContent);
            String correo = jsonNode.get("correo").asText();
            String contrasenia = jsonNode.get("contrasenia").asText();
            for (Usuario usuario : usuarios) {
                // Verifica si el usuario es válido, por ejemplo, utilizando la lógica de validación de credenciales
                if (usuario.getCredencial().validarCredencial(correo, contrasenia)) {
                    System.out.println(usuario.toString());

                    // Crear un ObjectNode para representar el JSON
                    ObjectNode jsonRespuesta = objectMapper.createObjectNode();

                    // Agregar campos al JSON
                    jsonRespuesta.put("nombre", usuario.getNombres());
                    jsonRespuesta.put("apellido_paterno", usuario.getApellido_paterno());
                    jsonRespuesta.put("apellido_materno", usuario.getApellido_materno());
                    jsonRespuesta.put("telefono", usuario.getTelefono());

                    // Convertir ObjectNode a una cadena JSON
                    String jsonString = objectMapper.writeValueAsString(jsonRespuesta);

                    return jsonString;
                }
            }
            return "";
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
