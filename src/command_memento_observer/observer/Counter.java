package command_memento_observer.observer;

import command_memento_observer.logic.BallPit;

import javax.swing.*;

public class Counter extends JLabel implements Subscriber<BallPit> {

    public Counter() {
        super();
        setText("Anzahl Bälle: 0");
    }

    @Override
    public void update(BallPit notification) {
        long count = notification.getBalls().size();
        setText("Anzahl Bälle: " + count);
    }
}