package strategypattern;

/**
 * fly 행동이 더이상 Duck class 안에 숨겨져 있지 않다.
 * 다른 객체에서도 나는 행동을 재사용 가능하게 됨.
 */
public interface FlyBehavior {
    void fly();
}
