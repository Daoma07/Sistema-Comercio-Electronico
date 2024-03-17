package endpoint;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MensajeSender {

    private final static String EXCHANGE_NAME = "exchange-microservicios";
    private final static String ROUTING_KEY = "microservicio-usuario";
    private static final String RESPONSE_QUEUE_PREFIX = "response-";

    public void enviarMensaje(String id, String mensaje) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("root");
        factory.setPassword("1234");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {

                String responseQueueName = RESPONSE_QUEUE_PREFIX + id;
                
                channel.basicPublish("", responseQueueName, null, mensaje.getBytes("UTF-8"));
            //            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            //
            //            String message = "Hola desde Java usario";
            //            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes());
            //            System.out.println(" [x] Enviado desde API Gateway: '" + message + "'");

        }
    }

}
