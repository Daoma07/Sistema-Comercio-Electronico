package conexionMensajeria;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConexionRabbitMQ implements IConexionMensajeria {

    private static final String HOST = "localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public ConexionRabbitMQ() {
    }

    @Override
    public synchronized Connection useConnection() throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        return factory.newConnection();

    }

}
