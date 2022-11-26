package command_memento_observer.logic;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ball implements Cloneable{
    public int x = 0;
    public int y = 0;
    public int ballWidth = 50;
    public int ballHeight = 50;
    int speedX;
    int speedY;
    public Color color;

    public Ball() {
        this.color = new Color(
                ThreadLocalRandom.current().nextInt(0,256),
                ThreadLocalRandom.current().nextInt(0,256),
                ThreadLocalRandom.current().nextInt(0,256));
        this.speedX = ThreadLocalRandom.current().nextInt(-10, 11);
        this.speedY = ThreadLocalRandom.current().nextInt(-10, 11);
    }

    public Ball(Color color) {
        this();
        this.color = color;
    }

    public Ball(int x, int y, Color color) {
        this(color);
        this.x = x;
        this.y = y;
    }

    public void updatePosAndSpeed(int max_x, int max_y) {
        if(x + ballWidth > max_x || x < 0) speedX *= (-1);
        if(y + ballHeight > max_y || y < 0) speedY *= (-1);
        x += speedX;
        y += speedY;
    }

    @Override
    public Ball clone() {
        try {
            Ball clone = (Ball) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
