package intro;

/**
 * 모든 오리가 날거나 꽥꽥거리는 기능이 있어야 하는 것은 아니므로, 상속이 올바를 방법은 아니다.
 */
public class DecoyDuck extends Duck{
    @Override
    void quack() {
        // 구현하지 않음
    }

    @Override
    void swim() {
        // 구현하지 않음
    }

    @Override
    void display() {
        // 구현하지 않음
    }
}
