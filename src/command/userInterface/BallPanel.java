package command.userInterface;

import command.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallPanel extends JPanel implements MouseListener, KeyListener {
    BallPit ballPit;
    int max_x, max_y;

    public BallPanel(BallPit ballPit, int max_x, int max_y) {
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.ballPit = ballPit;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Ball ball : this.ballPit.getBalls()) {
            g.setColor(ball.color);
            g.fillOval(ball.x, ball.y, ball.ballWidth, ball.ballHeight);
            ball.updatePosAndSpeed(max_x, max_y);
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Command command = null;
        switch (e.getKeyChar()) {
            case 'b' -> command = new AddBallCommand(new Ball(Color.BLUE), this.ballPit);
            case 'r' -> command = new AddBallCommand(new Ball(), this.ballPit);
            case '-' -> command = new RemoveBallComand(this.ballPit);
            case 'z' -> command = new UndoCommand();
        }
        if (command instanceof Undoable) UndoCommand.addCommand((Undoable) command);
        if (command != null) command.execute();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Command command = null;
        Color color = null;
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> color = Color.GREEN;
            case MouseEvent.BUTTON3 -> color = Color.RED;
        }
        if (color != null) {
            command = new AddBallCommand(new Ball(e.getX(), e.getY(), color), this.ballPit);
            command.execute();
            if (command instanceof Undoable) UndoCommand.addCommand((Undoable) command);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
