package endpoint;

import com.rabbitmq.client.*;
import conexionMensajeria.IConexionMensajeria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import observer.Observable;
import observer.Observer;

/**
 * Clase que representa un receptor de mensajes desde RabbitMQ
 *
 * Esta clase se encarga de recibir mensajes desde un intercambio de RabbitMQ y
 * pasarlos al gestor correspondiente para su procesamiento.
 */
public class MensajeReceiver implements Observable {

    // Nombre del intercambio
    private static final String EXCHANGE_NAME = "exchange-microservicios";
    // Clave de enrutamiento
    private static final String ROUTING_KEY = "microservicio-usuario";
    // Nombre de la cola
    private static final String QUEUE_NAME = "queue-microservicio-usuario";

    // Objeto para manejar la conexión a la mensajería
    private IConexionMensajeria conexionMensajeria;

    // Observadores encargados de reaccionar a mensajes que lleguen
    private final List<Observer> observers = new ArrayList<>();

    public MensajeReceiver(IConexionMensajeria conexionMensajeria) {
        this.conexionMensajeria = conexionMensajeria;
    }

    /**
     * Método para recibir mensajes desde RabbitMQ
     *
     * Este método establece una conexión con RabbitMQ, declara un intercambio y
     * una cola, y luego se pone a la escucha de mensajes en la cola. Cuando
     * llega un mensaje, lo pasa al gestor para su procesamiento.
     *
     *
     */
    public void escucharMensajes() throws Exception {

        Connection connection = conexionMensajeria.useConnection();
        Channel channel = connection.createChannel();

        configurarCanal(channel);

        System.out.println(" [*] Esperando mensajes desde API Gateway");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String mensaje = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Recibido desde API Gateway: '" + mensaje + "'");
            // Agregar el valor "correlationId"
            String id = delivery.getProperties().getCorrelationId();
            notifyObservers(id, mensaje);
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });

    }

    private void configurarCanal(Channel channel) throws IOException {
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String id, String mensaje) {
        for (Observer observer : new ArrayList<>(observers)) {
            observer.update(id, mensaje);
        }
    }
}
