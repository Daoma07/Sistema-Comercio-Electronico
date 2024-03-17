package messageDispatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MessageDispatcher {

    private final Map<String, MessageHandler<?>> handlers;

    public MessageDispatcher() {
        handlers = new HashMap<>();
    }

    public <T> void registerHandler(String messageType, MessageHandler<T> handler) {
        if (messageType != null && handler != null) {
            handlers.put(messageType, handler);
        } else {
            System.out.println("Datos faltantes");
        }
    }

    public <T> T dispatch(String messageType, String messageContent) {
        MessageHandler<?> handler = handlers.get(messageType);
        if (handler != null) {
            @SuppressWarnings("unchecked")
            MessageHandler<T> typedHandler = (MessageHandler<T>) handler;
            return typedHandler.handle(messageContent);
        } else {
            System.out.println("No se encontró ningún manejador para el tipo de mensaje: " + messageType);
            return null;
        }
    }

}
