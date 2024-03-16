/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.fabrica;

import DAO.interfaces.ICarritoDAO;
import DAO.interfaces.ICategoriaDAO;
import DAO.interfaces.IEstiloDAO;
import DAO.interfaces.IImagenDAO;
import DAO.interfaces.IProductoDAO;
import DAO.interfaces.IProducto_TallaDAO;
import DAO.interfaces.ITallaDAO;

/**
 *
 * @author HP
 */
public interface IFabricaDAO {

    ITallaDAO crearTallaDAO();
    
    ICarritoDAO crearCarritoDAO();
    
    ICategoriaDAO crearCategoriaDAO();
    
    IEstiloDAO crearEstiloDAO();
    
    IImagenDAO crearImagenDAO();
    
    IProductoDAO crearProductoDAO();
    
    IProducto_TallaDAO crearProductoTallaDAO();
}
