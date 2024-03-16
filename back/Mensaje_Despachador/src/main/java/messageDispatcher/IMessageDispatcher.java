/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package messageDispatcher;

import java.util.function.Function;

/**
 *
 * @author Daniel
 */
public interface IMessageDispatcher {

    public <T> void registerHandler(String messageType, Function<String, T> handler);

    public <T> T dispatch(String messageType, String messageContent);
}
