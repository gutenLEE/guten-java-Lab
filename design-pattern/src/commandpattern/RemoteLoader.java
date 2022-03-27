package commandpattern;

import commandpattern.command.*;
import commandpattern.invoker.RemoteControl;
import commandpattern.invoker.RemoteControlWithUndo;
import commandpattern.receiver.*;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        Light light = new Light();
        Fan fan = new Fan();
        GarageDoor door = new GarageDoor();
        Computer computer = new Computer();
        Robot robot = new Robot();
        Stereo stereo = new Stereo();
        Stove stove = new Stove();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        FanOnCommand fanOnCommand = new FanOnCommand(fan);
        FanOffCommand fanOffCommand = new FanOffCommand(fan);

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(door);
        GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(door);
        ComputerOnCommand computerOnCommand = new ComputerOnCommand(computer);
        ComputerOffCommand computerOffCommand = new ComputerOffCommand(computer);
        RobotOnCommand robotOnCommand = new RobotOnCommand(robot);
        RobotOffCommand robotOffCommand = new RobotOffCommand(robot);
        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
        StoveOnCommand stoveOnCommand = new StoveOnCommand(stove);
        StoveOffCommand stoveOffCommand = new StoveOffCommand(stove);

        remote.setCommand(0, lightOnCommand, lightOffCommand);
        remote.setCommand(1, fanOnCommand, fanOffCommand);
        remote.setCommand(2, garageDoorOpenCommand, garageDoorCloseCommand);
        remote.setCommand(3, computerOnCommand, computerOffCommand);
        remote.setCommand(4, robotOnCommand, robotOffCommand);
        remote.setCommand(5, stereoOnWithCDCommand, stereoOffCommand);
//        remote.setCommand(6, stoveOnCommand, stoveOffCommand);
        remote.onButtonWasPushed(1);
        remote.undoButtonWasPushed();
        remote.offButtonWasPushed(1);
        System.out.println(remote);
        remote.onButtonWasPushed(5);
        remote.onButtonWasPushed(4);
        remote.onButtonWasPushed(3);
        remote.onButtonWasPushed(2);
    }
}
