/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dominio.Credencial;
import dominio.Genero;
import dominio.TipoUsuario;
import dominio.Usuario;
import facade.Facade;
import facade.IFacade;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HP
 */
public class GenerarBasedeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IFacade facade = new Facade();

        Usuario usuario = new Usuario("Daniel", "Alameda",
                "Lopez", "6442121314", new Date(2002, 06, 07),
                Genero.MASCULINO, TipoUsuario.ENCARGADO,
                new Credencial("daoma222@hotmail.com", "123"));

        facade.useFacadeUsuario().crearUsuario(usuario);
    }

}
