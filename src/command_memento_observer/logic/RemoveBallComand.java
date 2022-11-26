package command_memento_observer.logic;

public class RemoveBallComand implements Command, Undoable {
    BallPit reciever;
    Ball removedBall;

    public RemoveBallComand(BallPit reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        this.removedBall = this.reciever.removeBall();
    }

    @Override
    public Command getReverseCommand() {
        return new AddBallCommand(removedBall, reciever);
    }
}
