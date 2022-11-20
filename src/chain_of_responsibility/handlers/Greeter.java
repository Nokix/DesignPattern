package chain_of_responsibility.handlers;

import chain_of_responsibility.server.Server;
import chain_of_responsibility.server.UserType;

public class Greeter extends Handler {
    private final Server server;

    public Greeter(Server server) {
        this.server = server;
    }

    @Override
    public boolean handle(String email, String password) {
        UserType type = server.getUserType(email);
        switch (type) {
            case USER -> System.out.println("Moin moin!");
            case ADMIN -> System.out.println("Guten Tag Hochwürden!");
        }
        return handleNext(email, password);
    }
}
