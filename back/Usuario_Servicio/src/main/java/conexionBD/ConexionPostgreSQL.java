/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Daniel
 */
public class ConexionPostgreSQL implements IConexionBD {

    private static EntityManagerFactory factory;

    @Override
    public EntityManagerFactory useConnection() throws SQLException {

        try {
            if (factory == null || !factory.isOpen()) {
                factory = Persistence.createEntityManagerFactory("persistencia");
            }
            return factory;
        } catch (PersistenceException e) {
            throw new SQLException("Error al crear la EntityManagerFactory", e);
        }
    }

    public static void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
