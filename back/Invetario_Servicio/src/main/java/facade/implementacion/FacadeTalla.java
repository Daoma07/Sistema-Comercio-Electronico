/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Talla;
import facade.interfaces.IFacadeTalla;
import java.util.List;

/**
 *
 * @author HP
 */
public class FacadeTalla implements IFacadeTalla {

    private IFabricaDAO fabricaDAO;

    public FacadeTalla() {
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public Talla crearTalla(Talla talla) {
        return fabricaDAO.crearTallaDAO().crearTalla(talla);
    }

    @Override
    public boolean actualizarTalla(Talla talla) {
        return fabricaDAO.crearTallaDAO().actualizarTalla(talla);
    }

    @Override
    public Talla consultarTallaID(Long id) {
        return fabricaDAO.crearTallaDAO().consultarTallaID(id);
    }

    @Override
    public boolean eliminarTalla(Talla talla) {
        return fabricaDAO.crearTallaDAO().eliminarTalla(talla);
    }

    @Override
    public List<Talla> obtenerTodasTallas() {
        return fabricaDAO.crearTallaDAO().obtenerTodasTallas();
    }

}
