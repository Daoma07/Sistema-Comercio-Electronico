package facade;

import java.util.function.Function;
import messageDispatcher.IMessageDispatcher;
import messageDispatcher.MessageDispatcher;

public class FacadeMessageDispatcher implements IFacadeMessageDispatcher {

    IMessageDispatcher messageDispatcher;

    public FacadeMessageDispatcher() {
        this.messageDispatcher = new MessageDispatcher();
    }

    @Override
    public <T> void registerHandler(String messageType, Function<String, T> handler
    ) {
        this.messageDispatcher.registerHandler(messageType, handler);
    }

    @Override
    public <T> T dispatch(String messageType,
            String messageContent
    ) {
        return this.dispatch(messageType, messageContent);
    }

}
