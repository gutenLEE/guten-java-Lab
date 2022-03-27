package commandpattern.command;

import commandpattern.receiver.Fan;
import commandpattern.receiver.Robot;


public class RobotOnCommand implements Command {

    Robot robot;

    public RobotOnCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.on();
    }

    @Override
    public void undo() {
        robot.off();
    }
}
