package conexionBD;

import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;

public interface IConexionBD {

    EntityManagerFactory useConnectionMySQL() throws SQLException;
}
