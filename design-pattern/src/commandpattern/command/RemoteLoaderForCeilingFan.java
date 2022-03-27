package commandpattern.command;

import commandpattern.invoker.RemoteControlWithUndo;
import commandpattern.receiver.CeilingFan;

public class RemoteLoaderForCeilingFan {

    public static void main(String[] args) {
        CeilingFan ceilingFan = new CeilingFan("거실");

        CeilingFanHighCommand fanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand fanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand fanOffCommand = new CeilingFanOffCommand(ceilingFan);

        RemoteControlWithUndo remote = new RemoteControlWithUndo();
        remote.setCommand(0, fanHighCommand, fanOffCommand);
        remote.setCommand(1, fanMediumCommand, fanOffCommand);

        remote.onButtonWasPushed(0);
        remote.undoButtonWasPushed();
        System.out.println(remote);
    }

}
