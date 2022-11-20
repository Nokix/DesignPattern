package chain_of_responsibility.server;

import chain_of_responsibility.handlers.Handler;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> mailPasswordMap = new HashMap<>();
    private Map<String, UserType> mailTypeMap = new HashMap<>();
    private Handler loginHandler;

    public void register(String email, String password, UserType userType) {
        mailPasswordMap.put(email, password);
        mailTypeMap.put(email, userType);
    }

    public void setLoginHandler(Handler loginHandler) {
        this.loginHandler = loginHandler;
    }

    public boolean logIn(String password, String email) {
        if (this.loginHandler != null && this.loginHandler.handle(email, password)) {
            System.out.println("Authorization successful!");
            return true;
        }
        return false;
    }

    public boolean isValidPassword(String email, String password) {
        return mailPasswordMap.get(email).equals(password);
    }

    public boolean userExists(String email) {
        return mailTypeMap.containsKey(email);
    }

    public UserType getUserType(String email) {
        return mailTypeMap.get(email);
    }
}
