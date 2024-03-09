/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.interfaces;

import dominio.Talla;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author HP
 */
public interface IFacadeTalla {

    Talla crearTalla(Talla talla) throws PersistenceException;

    boolean actualizarTalla(Talla talla);

    Talla consultarTallaID(Long id);

    boolean eliminarTalla(Talla talla);

    List<Talla> obtenerTodasTallas();
}
