package command_memento_observer.logic;

import command_memento_observer.observer.Publisher;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BallPit implements Cloneable{

    private final Stack<Ball> balls = new Stack<>();

    private Publisher<BallPit> publisher = new Publisher<>();

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public void addBall(Ball ball) {
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

    @Override
    public BallPit clone() {
        BallPit clone = new BallPit();
        this.balls.stream().map(Ball::clone).forEach(clone.balls::add);
        clone.publisher = this.publisher;
        return clone;
    }
}
