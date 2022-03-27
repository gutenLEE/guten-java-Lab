package commandpattern.command;

import commandpattern.receiver.Stereo;
import commandpattern.receiver.Stove;

public class StoveOffCommand implements Command {

    Stove stove;

    public StoveOffCommand(Stove stove) {
        this.stove = stove;
    }

    @Override
    public void execute() {
        stove.off();
    }

    @Override
    public void undo() {
        stove.on();
    }


}
