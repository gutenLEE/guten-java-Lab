package commandpattern.command;

import commandpattern.receiver.Stereo;

public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}

/*

    Stereo stereo;
    CD cd;

    public StereoOnWithCDCommand(Stereo stereo, CD cd) {
        this.stereo = stereo;
        this.cd = cd;
    }
 */