package chain_of_responsibility.handlers;

import chain_of_responsibility.server.Server;

public class UserExistsChecker extends Handler {
    private final Server server;

    public UserExistsChecker(Server server) {
        this.server = server;
    }

    @Override
    public boolean handle(String email, String password) {
        if (!server.userExists(email)) {
            System.out.println("There is no User with this Mail");
            return false;
        }
        return handleNext(email, password);
    }
}
