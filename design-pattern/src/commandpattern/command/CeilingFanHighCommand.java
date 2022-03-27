package commandpattern.command;

import commandpattern.receiver.CeilingFan;

public class CeilingFanHighCommand implements Command {

    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        System.out.println("fan speed is set to high");
        this.prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            System.out.println("선풍기 속도 high");
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            System.out.println("선풍기 속도 medium");
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            System.out.println("선풍기 속도 low");
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            System.out.println("선풍기 속도 off");
            ceilingFan.off();
        }
    }
}
