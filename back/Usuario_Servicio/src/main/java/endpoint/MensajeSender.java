package endpoint;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import conexionMensajeria.IConexionMensajeria;
import observer.Observer;

/**
 * Clase que proporciona funcionalidades para enviar mensajes a través de
 * RabbitMQ.
 *
 * Esta clase se encarga de establecer una conexión con RabbitMQ utilizando una
 * implementación de la interfaz IConexionMensajeria proporcionada en el
 * constructor. Luego, utiliza esta conexión para enviar un mensaje a una cola
 * específica de RabbitMQ, con el fin de comunicarse con un componente externo
 * como API Gateway.
 */
public class MensajeSender implements Observer {

    // Prefijo para el nombre de la cola de respuesta
    private static final String RESPONSE_QUEUE_PREFIX = "response-";
    // Objeto que proporciona la conexión a RabbitMQ
    private final IConexionMensajeria conexionMensajeria;

    /**
     * Constructor de la clase MensajeSender.
     *
     * @param conexionMensajeria Objeto que implementa la interfaz
     * IConexionMensajeria y proporciona la conexión a RabbitMQ.
     */
    public MensajeSender(IConexionMensajeria conexionMensajeria) {
        this.conexionMensajeria = conexionMensajeria;
    }

    /**
     * Método para enviar un mensaje a través de RabbitMQ.
     *
     * Este método establece una conexión con RabbitMQ utilizando la
     * implementación de IConexionMensajeria proporcionada en el constructor.
     * Luego, utiliza esta conexión para enviar un mensaje a una cola específica
     * de RabbitMQ, con el fin de comunicarse con un componente externo como API
     * Gateway.
     *
     * @param id Identificador del mensaje.
     * @param mensaje Contenido del mensaje a enviar.
     */
    public void enviarMensaje(String id, String mensaje) {

        try (Connection connection = conexionMensajeria.useConnection(); Channel channel = connection.createChannel()) {

            String responseQueueName = RESPONSE_QUEUE_PREFIX + id;

            channel.basicPublish("", responseQueueName, null, mensaje.getBytes("UTF-8"));
            System.out.println(" [x] Enviado respuesta a API Gateway: '" + id + "'");

        } catch (Exception e) {
            System.err.println("Error al enviar mensaje: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, String mensaje) {
        enviarMensaje(id, mensaje);
    }

}
