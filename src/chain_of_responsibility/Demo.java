package chain_of_responsibility;

import chain_of_responsibility.handlers.*;
import chain_of_responsibility.server.Server;
import chain_of_responsibility.server.UserType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.register("admin@mail.de", "safepassword", UserType.ADMIN);
        server.register("jochen@mail.de", "1234", UserType.USER);

        server.setLoginHandler(Handler.link(
                new ThrottlingChecker(3),
                new UserExistsChecker(server),
                new PasswordChecker(server),
                new Greeter(server)));

        boolean success;
        do {
            System.out.println("Enter email:");
            String email = reader.readLine();
            System.out.println("Input password:");
            String password = reader.readLine();
            success = server.logIn(password, email);
        } while (!success);
    }
}
