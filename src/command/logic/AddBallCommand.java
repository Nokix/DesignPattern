package command.logic;

public class AddBallCommand implements Command, Undoable {
    Ball ball;
    BallPit reciever;

    public AddBallCommand(Ball ball, BallPit ballPit) {
        this.ball = ball;
        this.reciever = ballPit;
    }


    @Override
    public void execute() {
        reciever.addBall(ball);
    }

    @Override
    public Command getReverseCommand() {
        return new RemoveBallComand(this.reciever);
    }
}
