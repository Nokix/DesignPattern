package command;

import command.logic.BallPit;
import command.observer.Counter;
import command.userInterface.BallPanel;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    public Demo() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        BallPit ballPit = new BallPit();
        BallPanel ballPanel = new BallPanel(ballPit,800, 600);

        Counter counter = new Counter();
        ballPit.getPublisher().subscribe(counter);
        ballPanel.add(counter, BorderLayout.PAGE_END);

        add(ballPanel);
    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
