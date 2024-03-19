package main;

import conexionMensajeria.IConexionMensajeria;
import endpoint.MensajeReceiver;
import endpoint.MensajeSender;
import endpoint.gestor.Gestor;
import facade.IFacade;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracionServicio {

    private Gestor gestor;
    private MensajeReceiver mensajeReceiver;
    private MensajeSender mensajeSender;

    public ConfiguracionServicio(IFacade facade, IConexionMensajeria conexionMensajeria) {
        this.gestor = new Gestor(facade);
        this.mensajeReceiver = new MensajeReceiver(conexionMensajeria);
        this.mensajeSender = new MensajeSender(conexionMensajeria);
        iniciarObservadores();
    }

    private void iniciarObservadores() {
        mensajeReceiver.addObserver(gestor);
        gestor.addObserver(mensajeSender);
    }

    public void iniciarServicio() {
        try {
            mensajeReceiver.escucharMensajes();
        } catch (Exception ex) {
            Logger.getLogger(ConfiguracionServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
