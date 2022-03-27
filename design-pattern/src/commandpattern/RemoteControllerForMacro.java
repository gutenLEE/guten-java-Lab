package commandpattern;

import commandpattern.command.*;
import commandpattern.invoker.RemoteControlWithUndo;
import commandpattern.receiver.CeilingFan;
import commandpattern.receiver.Computer;
import commandpattern.receiver.Light;

public class RemoteControllerForMacro {
    public static void main(String[] args) {

        Light light = new Light();
        CeilingFan ceilingFan = new CeilingFan("room1");
        Computer computer = new Computer();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        CeilingFanHighCommand fanHighCommand = new CeilingFanHighCommand(ceilingFan);
        ComputerOnCommand computerOnCommand = new ComputerOnCommand(computer);

        Command[] commands = {lightOnCommand, fanHighCommand, computerOnCommand};
        MacroCommand macroCommand = new MacroCommand(commands);
        RemoteControlWithUndo remote = new RemoteControlWithUndo();
        remote.setCommand(0, macroCommand, macroCommand);
        System.out.println(remote);
        remote.onButtonWasPushed(0);
    }
}
