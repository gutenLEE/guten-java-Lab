package commandpattern.receiver;

public class GarageDoor {
    public void up() {
        System.out.println("차고가 열렸습니다");
    }

    public void down() {
        System.out.println("차고를 닫혔습니다");
    }

    public void stop() {
        System.out.println("차고 문이 멈췄습니다");
    }

    public void lightOn() {
        System.out.println("차고 불이 켜졌습니다.");
    }

    public void lightOff() {
        System.out.println("차고 불이 꺼졌습니다.");
    }
}
