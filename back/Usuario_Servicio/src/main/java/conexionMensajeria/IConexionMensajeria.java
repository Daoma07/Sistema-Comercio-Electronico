package conexionMensajeria;

import com.rabbitmq.client.Connection;

/**
 *
 * @author Daniel
 */
public interface IConexionMensajeria {

    Connection useConnection() throws Exception;
}
