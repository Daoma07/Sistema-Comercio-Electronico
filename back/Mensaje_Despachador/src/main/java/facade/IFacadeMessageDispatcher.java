/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package facade;

import java.util.function.Function;
import messageDispatcher.MessageHandler;

/**
 *
 * @author Daniel
 */
public interface IFacadeMessageDispatcher {

    public <T> void registerHandler(String messageType, MessageHandler<T> handler);

    public <T> T dispatch(String messageType, String messageContent);
}
