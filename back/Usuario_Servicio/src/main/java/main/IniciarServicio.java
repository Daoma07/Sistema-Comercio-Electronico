package main;

import conexionMensajeria.ConexionRabbitMQ;
import conexionMensajeria.IConexionMensajeria;
import facade.Facade;
import facade.IFacade;
import negocio.fabrica.FabricaNegocio;

public class IniciarServicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        IFacade facade = new Facade(new FabricaNegocio());
        IConexionMensajeria conexionMensajeria = new ConexionRabbitMQ();

        ConfiguracionServicio configuracionServicio = new ConfiguracionServicio(facade,
                conexionMensajeria);

        configuracionServicio.iniciarServicio();
    }

}
