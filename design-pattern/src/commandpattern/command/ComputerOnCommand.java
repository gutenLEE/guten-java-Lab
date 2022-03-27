package commandpattern.command;

import commandpattern.receiver.Computer;

import java.util.concurrent.CompletableFuture;

public class ComputerOnCommand implements Command {
    Computer computer;

    public ComputerOnCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.on();
    }

    @Override
    public void undo() {
        computer.off();
    }
}
