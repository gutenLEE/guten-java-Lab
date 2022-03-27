package commandpattern.command;

import commandpattern.receiver.Stereo;
import commandpattern.receiver.Stove;

public class StoveOnCommand implements Command {

    Stove stove;

    public StoveOnCommand(Stove stove) {
        this.stove = stove;
    }

    @Override
    public void execute() {
        stove.on();
    }

    @Override
    public void undo() {
        stove.off();
    }
}
