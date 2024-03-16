/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.fabrica;

import DAO.implementacion.CarritoDAO;
import DAO.implementacion.CategoriaDAO;
import DAO.implementacion.EstiloDAO;
import DAO.implementacion.ImagenDAO;
import DAO.implementacion.ProductoDAO;
import DAO.implementacion.Producto_TallaDAO;
import DAO.interfaces.ICarritoDAO;
import DAO.interfaces.ICategoriaDAO;
import DAO.interfaces.IEstiloDAO;
import DAO.interfaces.IImagenDAO;
import DAO.interfaces.IProductoDAO;
import DAO.interfaces.IProducto_TallaDAO;
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

    @Override
    public ICarritoDAO crearCarritoDAO() {
        try{
            return new CarritoDAO(conexionBD);
        }catch(SQLException ex){
            System.err.println("Error al crear CarritoDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICategoriaDAO crearCategoriaDAO() {
        try{
            return new CategoriaDAO(conexionBD);
        }catch(SQLException ex){
            System.err.println("Error al crear CatergorisDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IEstiloDAO crearEstiloDAO() {
        try{
            return new EstiloDAO(conexionBD);
        }catch(SQLException ex){
            System.err.println("Error al crear EstiloDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IImagenDAO crearImagenDAO() {
        try{
            return new ImagenDAO(conexionBD);
        }catch(SQLException ex){
            System.err.println("Error al crear ImagenDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IProductoDAO crearProductoDAO() {
        try{
            return new ProductoDAO(conexionBD);
        }catch(SQLException ex){
            System.err.println("Error al crear ProdcutoDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IProducto_TallaDAO crearProductoTallaDAO() {
        try{
            return new Producto_TallaDAO(conexionBD);
        }catch(SQLException ex){
            System.err.println("Error al crear Prodcuto_TallaDAO: " + ex.getMessage());
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
