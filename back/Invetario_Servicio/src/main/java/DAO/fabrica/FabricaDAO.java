/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.fabrica;

import conexionBD.ConexionMysql;
import conexionBD.IConexionBD;
import dao.fabrica.IFabricaDAO;
import dao.implementacion.TallaDAO;
import DAO.interfaces.ITallaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FabricaDAO implements IFabricaDAO {

    private IConexionBD conexionBD;

    public FabricaDAO() {
        this.conexionBD = new ConexionMysql();
    }

    @Override
    public ITallaDAO crearTallaDAO() {
        try {
            return new TallaDAO(conexionBD);
        } catch (SQLException ex) {
            System.err.println("Error al crear TallaDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
