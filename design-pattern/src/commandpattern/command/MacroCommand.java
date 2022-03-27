package commandpattern.command;

import commandpattern.receiver.CeilingFan;
import commandpattern.receiver.Fan;
import commandpattern.receiver.Stove;

public class MacroCommand implements Command {

    Command[] onCommands;
    Command[] offCommands;
    NoCommand noCommand;
    
    public MacroCommand() {
        onCommands = new Command[3];
        onCommands[0] = new FanOnCommand(new Fan());
        onCommands[1] = new CeilingFanHighCommand(new CeilingFan("room1"));
        onCommands[2] = new StoveOnCommand(new Stove());

        offCommands = new Command[3];
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
