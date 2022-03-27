package commandpattern.command;

import commandpattern.receiver.CeilingFan;
import commandpattern.receiver.Fan;
import commandpattern.receiver.Stove;

public class MacroCommand implements Command {

    Command[] onCommands;
    Command[] offCommands;
    NoCommand noCommand;

    public MacroCommand(Command[] onCommands) {
        this.onCommands = onCommands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < onCommands.length; i++) {
            onCommands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < onCommands.length; i++) {
            onCommands[i].execute();
        }
    }
}
