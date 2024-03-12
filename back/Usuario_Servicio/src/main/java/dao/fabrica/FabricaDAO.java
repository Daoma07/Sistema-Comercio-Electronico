/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.fabrica;

import conexionBD.ConexionPostgreSQL;
import conexionBD.IConexionBD;
import dao.implementacion.CredencialDAO;
import dao.implementacion.DestinatarioDAO;
import dao.implementacion.DireccionDAO;
import dao.implementacion.UsuarioDAO;
import dao.inerfaces.ICredencialDAO;
import dao.inerfaces.IDestinatarioDAO;
import dao.inerfaces.IDireccionDAO;
import dao.inerfaces.IUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class FabricaDAO implements IFabricaDAO {

    private IConexionBD conexionBD;

    public FabricaDAO() {
        this.conexionBD = new ConexionPostgreSQL();
    }

    @Override
    public ICredencialDAO crearCredencialDAO() {
        try {
            return new CredencialDAO(conexionBD);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IDestinatarioDAO crearDestinatarioDAO() {
        try {
            return new DestinatarioDAO(conexionBD);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IDireccionDAO crearDireccionDAO() {
        try {
            return new DireccionDAO(conexionBD);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO() {
        try {
            return new UsuarioDAO(conexionBD);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
