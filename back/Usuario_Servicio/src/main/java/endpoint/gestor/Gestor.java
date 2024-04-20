package endpoint.gestor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import facade.FacadeMessageDispatcher;
import facade.IFacade;
import facade.IFacadeMessageDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observable;
import observer.Observer;

public class Gestor implements Observer, Observable, IGestor {

    private final IFacade facade;
    private final List<Observer> observers = new ArrayList<>();
    private final IFacadeMessageDispatcher facadeMessageDispatcher;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Gestor(IFacade facade) {
        this.facade = facade;
        this.facadeMessageDispatcher = new FacadeMessageDispatcher();
        this.registrarManejadores();
    }

    @Override
    public void procesarMensaje(String id, String mensaje) {
        try {
            JsonNode jsonNode = objectMapper.readTree(mensaje);
            // Acceder a las propiedades del JSON
            String action = jsonNode.get("action").asText();
            String handler = facadeMessageDispatcher.dispatch(action, mensaje);
            notifyObservers(id, handler);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Registrar los manejadores
    private void registrarManejadores() {
        facadeMessageDispatcher.registerHandler("login", facade::loginUsuario);
        facadeMessageDispatcher.registerHandler("registrar", facade::registarUsuario);

    }

    @Override
    public void update(String id, String mensaje) {
        procesarMensaje(id, mensaje);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String id, String mensaje) {
        for (Observer observer : new ArrayList<>(observers)) {
            observer.update(id, mensaje);
        }
    }

}
