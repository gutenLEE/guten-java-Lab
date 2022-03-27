package commandpattern.command;

import commandpattern.receiver.Fan;
import commandpattern.receiver.Light;

public class FanOnCommand implements Command {

    Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}
