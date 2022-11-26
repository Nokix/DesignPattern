package command_memento_observer.observer;

public interface Subscriber<T> {
    void update(T notification);
}
