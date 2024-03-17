package facade;

import messageDispatcher.MessageDispatcher;
import messageDispatcher.MessageHandler;

public class FacadeMessageDispatcher implements IFacadeMessageDispatcher {

    MessageDispatcher messageDispatcher;

    public FacadeMessageDispatcher() {
        this.messageDispatcher = new MessageDispatcher();
    }

    @Override
    public <T> void registerHandler(String messageType, MessageHandler<T> handler) {
        messageDispatcher.registerHandler(messageType, handler);
    }

    @Override
    public <T> T dispatch(String messageType, String messageContent) {
        return messageDispatcher.dispatch(messageType, messageContent);
    }

}
