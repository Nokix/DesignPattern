package command;

import command.logic.BallPit;
import command.userInterface.BallPanel;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    public Demo() throws HeadlessException {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BallPanel ballAnimation = new BallPanel(new BallPit(),800, 600);
        add(ballAnimation);
    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
