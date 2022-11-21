package command.userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallAnimation extends JPanel implements MouseListener, KeyListener {
    private final int max_y;
    private final int max_x;
    int x = 0;
    int y = 0;
    int ballWidth = 50;
    int ballHeight = 50;
    int speedX = 10;
    int speedY = 10;

    public BallAnimation(int w, int h) {
        addMouseListener(this);
        addKeyListener(this);
        this.setFocusable(true);
        this.max_x = w - ballWidth;
        this.max_y = h - ballHeight;
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);
        g.fillOval(x, y, ballWidth, ballHeight);

        g.setColor(Color.GREEN);
        g.fillOval(x+100, y + 100, ballWidth, ballHeight);

        if(x > max_x || x < 0) speedX *= (-1);
        if(y > max_y || y < 0) speedY *= (-1);

        x += speedX;
        y += speedY;

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();


        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
