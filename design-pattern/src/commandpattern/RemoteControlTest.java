package commandpattern;

import commandpattern.command.FanOnCommand;
import commandpattern.command.GarageDoorOpenCommand;
import commandpattern.command.LightOnCommand;
import commandpattern.command.StoveOnCommand;
import commandpattern.receiver.Fan;
import commandpattern.receiver.GarageDoor;
import commandpattern.receiver.Light;
import commandpattern.receiver.Stove;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        GarageDoor door = new GarageDoor();
        GarageDoorOpenCommand doorUp = new GarageDoorOpenCommand(door);

        Fan fan = new Fan();
        FanOnCommand fanOn = new FanOnCommand(fan);

        Stove stove = new Stove();
        StoveOnCommand stoveOn = new StoveOnCommand(stove);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(doorUp);
        remote.buttonWasPressed();
        remote.setCommand(fanOn);
        remote.buttonWasPressed();
        remote.setCommand(stoveOn);
        remote.buttonWasPressed();

    }
}
