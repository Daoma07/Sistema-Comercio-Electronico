package endpoint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rabbitmq.client.*;
import negocio.implementaciones.UsuarioNegocio;

public class MensajeReceiver {

    private final static String EXCHANGE_NAME = "exchange-microservicios";
    private final static String ROUTING_KEY = "microservicio-usuario";
    private final static String QUEUE_NAME = "queue-microservicio-usuario";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Gestor gestor = new Gestor();
        factory.setHost("localhost");
        factory.setUsername("root");
        factory.setPassword("1234");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        System.out.println(" [*] Esperando mensajes desde API Gateway. Para salir, presiona CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Recibido desde API Gateway: '" + message + "'");

            // Agregar el valor "correlationId"
            String correlationId = delivery.getProperties().getCorrelationId();

            gestor.getMessage(correlationId, message);
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });

    }

}
