package command.logic;

import java.util.Stack;

public class UndoCommand implements Command {
    static Stack<Undoable> commandStack = new Stack<>();

    public static void addCommand(Undoable command) {
        commandStack.push(command);
    }

    public void execute() {
        if (commandStack.empty()) return;
        commandStack.pop().getReverseCommand().execute();
    }
}
