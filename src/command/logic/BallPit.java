package command.logic;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BallPit {

    private final Stack<Ball> balls = new Stack<>();

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    void addBall(Ball ball) {
        balls.push(ball);
    }

    Ball removeBall() {
        return balls.empty() ? null : balls.pop();
    }
}
