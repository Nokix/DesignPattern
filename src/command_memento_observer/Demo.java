package command_memento_observer;

import command_memento_observer.logic.BallPit;
import command_memento_observer.observer.Counter;
import command_memento_observer.userInterface.BallPanel;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    public Demo() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        BallPit ballPit = new BallPit();
        BallPanel ballPanel = new BallPanel(ballPit,800, 600);
        ballPanel.setLayout(new BoxLayout(ballPanel, BoxLayout.Y_AXIS));

        Counter counter = new Counter();
        ballPit.getPublisher().subscribe(counter);
        ballPanel.add(counter);

        JLabel comp = new JLabel("Implement Me.");
        ballPanel.add(comp);

        add(ballPanel);
    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
