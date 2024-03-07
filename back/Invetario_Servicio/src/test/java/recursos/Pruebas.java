/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import dominio.Talla;
import facade.Facade;
import facade.IFacade;

/**
 *
 * @author HP
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        IFacade facade = new Facade();

        Talla talla = new Talla("123", "123");

        facade.useFacadeTalla().crearTalla(talla);

    }

}
