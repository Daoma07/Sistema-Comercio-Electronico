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
@FunctionalInterface
public interface MessageHandler<T> {

    T handle(String messageContent);
}
