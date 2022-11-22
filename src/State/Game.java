package State;

import State.Tamagotschi.Tamagotchi;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();

        System.out.println("Welcome to Tamagotschi Island!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to do? (f)eed or make (d)ance or ask for (s)tatus?");
            String line = scanner.nextLine();
            String resonse = switch (line) {
                case "f" -> tamagotchi.feed();
                case "d" -> tamagotchi.makeDance();
                case "s" -> tamagotchi.getState();
                default -> "type in f or d, please.";
            };
            System.out.println(resonse);
            System.out.println();
        }
    }
}
