/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import conexionBD.ConexionMysql;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class GenerarBasedeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConexionMysql conexion = new ConexionMysql();
            EntityManagerFactory factory = conexion.useConnectionMySQL();
            conexion.closeEntityManagerFactory();
            ConexionMysql.closeEntityManagerFactory();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());

        }
    }

}
