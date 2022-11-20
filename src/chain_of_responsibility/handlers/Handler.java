package chain_of_responsibility.handlers;

public abstract class Handler {
    private Handler next;

    public abstract boolean handle(String email, String password);

    public static Handler link(Handler first, Handler... chain) {
        Handler head = first;
        for (Handler next : chain) {
            head.next = next;
            head = next;
        }
        return first;
    }

    protected boolean handleNext(String email, String password) {
        return next == null || next.handle(email, password);
    }
}
