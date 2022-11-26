package command.observer;

public interface Subscriber<T> {
    void update(T notification);
}
