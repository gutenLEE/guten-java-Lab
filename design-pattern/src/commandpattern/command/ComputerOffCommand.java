package commandpattern.command;

import commandpattern.receiver.Computer;

public class ComputerOffCommand implements Command {
    Computer computer;

    public ComputerOffCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.on();
    }

    @Override
    public void undo() {
        computer.on();
    }


}
