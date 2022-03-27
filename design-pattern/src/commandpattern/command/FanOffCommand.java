package commandpattern.command;

import commandpattern.receiver.Fan;
import commandpattern.receiver.Light;

public class FanOffCommand implements Command {

    Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
    }
}
