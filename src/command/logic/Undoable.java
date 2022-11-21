package command.logic;

public interface Undoable {
    Command getReverseCommand();
}
