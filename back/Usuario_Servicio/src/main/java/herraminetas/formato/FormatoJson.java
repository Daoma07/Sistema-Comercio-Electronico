package herraminetas.formato;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dominio.Credencial;
import dominio.Direccion;
import dominio.Genero;
import dominio.TipoUsuario;
import dominio.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormatoJson {

    private ObjectMapper objectMapper;

    public FormatoJson() {
        this.objectMapper = new ObjectMapper();
    }

    public Usuario convertirJsonCliente(String mensaje) {
        try {
            JsonNode jsonNode = objectMapper.readTree(mensaje);
            String nombres = jsonNode.get("nombres").asText();
            String apellido_paterno = jsonNode.get("apellido_paterno").asText();
            String apellido_materno = jsonNode.get("apellido_materno").asText();
            String telefono = jsonNode.get("telefono").asText();
            String fechaNacimiento = jsonNode.get("fecha_nacimiento").asText();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date dateObject = dateFormat.parse(fechaNacimiento);

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
            String numero = String.valueOf(jsonNode.get("numero").asInt());
            String colonia = jsonNode.get("colonia").asText();
            String ciudad = jsonNode.get("ciudad").asText();
            String estado = jsonNode.get("estado").asText();
            String codigo_postal = jsonNode.get("codigo_postal").asText();

            Credencial credencial = new Credencial(correo, contrasenia);

            List<Direccion> direcciones = new ArrayList<>();
            Direccion direccion = new Direccion(calle, numero, colonia, ciudad, estado, codigo_postal);
            direcciones.add(direccion);
            System.out.println(fechaNacimiento);
            Usuario usuario = new Usuario(nombres, apellido_paterno,
                    apellido_materno, telefono, dateObject,
                    genero, TipoUsuario.CLIENTE, credencial, direcciones);

            return usuario;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FormatoJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FormatoJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Credencial extrerCredenciales(String mensaje) {
        try {
            JsonNode jsonNode = objectMapper.readTree(mensaje);
            String correo = jsonNode.get("correo").asText();
            String contrasenia = jsonNode.get("contrasenia").asText();
            return new Credencial(correo, contrasenia);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FormatoJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String crearJsonRespuesta(String mensaje, String contenido) {
        try {
            ObjectNode jsonRespuesta = objectMapper.createObjectNode();

            jsonRespuesta.put("msg", mensaje);
            jsonRespuesta.put("id", contenido);

            // Convertir ObjectNode a una cadena JSON
            String jsonString = objectMapper.writeValueAsString(jsonRespuesta);

            return jsonString;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FormatoJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
