package messageDispatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MessageDispatcher implements IMessageDispatcher {

    private final Map<String, Function<String, ?>> handlers;

    public MessageDispatcher() {
        handlers = new HashMap<>();
    }

    @Override
    public <T> void registerHandler(String messageType, Function<String, T> handler) {
        if (messageType == null && handler == null) {
            System.out.println("Datos faltantes");
        } else {
            handlers.put(messageType, handler);
        }

    }

    @Override
    public <T> T dispatch(String messageType, String messageContent) {
        Function<String, ?> handler = handlers.get(messageType);
        if (handler != null) {
            if (messageContent != null) {
                // Invocar al manejador y devolver el resultado
                return (T) handler.apply(messageContent);
            } else {
                System.out.println("No se encontraron los datos correspondiente");
                return null;
            }
        } else {
            System.out.println("No se encontró ningún manejador para el tipo de mensaje: " + messageType);
            return null;
        }
    }

}
