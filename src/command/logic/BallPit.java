package command.logic;

import command.observer.Publisher;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BallPit {

    private final Stack<Ball> balls = new Stack<>();

    private Publisher<BallPit> publisher = new Publisher<>();

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    void addBall(Ball ball) {
        balls.push(ball);
        publisher.notifySubscribers(this);
    }

    Ball removeBall() {
        Ball result = balls.empty() ? null : balls.pop();
        publisher.notifySubscribers(this);
        return result;
    }

    public Publisher<BallPit> getPublisher() {
        return publisher;
    }
}
