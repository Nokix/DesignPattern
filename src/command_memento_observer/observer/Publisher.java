package command_memento_observer.observer;

import java.util.ArrayList;
import java.util.Collection;

public class Publisher<T> {
    Collection<Subscriber<T>> subscribers = new ArrayList<>();

    public void subscribe(Subscriber<T> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber<T> subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(T notification) {
        subscribers.parallelStream().forEach(subscriber -> subscriber.update(notification));
    }
}
