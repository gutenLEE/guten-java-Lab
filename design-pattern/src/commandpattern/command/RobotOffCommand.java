package commandpattern.command;

import commandpattern.receiver.Fan;
import commandpattern.receiver.Robot;

public class RobotOffCommand implements Command {


    Robot robot;

    public RobotOffCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.off();
    }

    @Override
    public void undo() {
        robot.on();
    }
}
