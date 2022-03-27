package commandpattern.invoker;

import commandpattern.command.Command;
import commandpattern.command.NoCommand;

public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;
    Command commandUndo;

    // 초기화
    public RemoteControlWithUndo() {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        commandUndo = noCommand;
    }

    /**
     * 커맨드 인스턴스 전달 받기
     * @param slot
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }


    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        commandUndo = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        commandUndo = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        commandUndo.undo();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n --------- Remote Controller ----------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "     "
                    + offCommands[i].getClass().getName() + "\n");
        }
        sb.append("\n");
        sb.append(commandUndo.getClass().getName());
        return sb.toString();
    }
}
