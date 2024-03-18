package messageDispatcher;

import java.util.function.Function;

@FunctionalInterface
public interface MessageHandler<T> {

    T handle(String messageContent);
}
