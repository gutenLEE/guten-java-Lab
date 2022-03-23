package commandpattern.receiver;

public class Stereo {
    public void off() {
        System.out.println("스테레오 볼륨이 꺼졌습니다.");
    }
    public void on() {
        System.out.println("스테레오 볼륨이 켜졌습니다.");
    }

    public void setCD() {
        System.out.println("CD setting");
    }

    public void setDvd() {
        System.out.println("Dvd setting");
    }

    public void setRadio() {
        System.out.println("Radio setting");
    }

    public void setVolume() {
        System.out.println("Volume setting");
    }

    public void setVolume(int volume) {
        System.out.println("Stereo volume set " + volume);
    }
}
