package effectivejava.item19;

/**
 * @author gutenlee
 * @since 2023/01/17
 */
public class Super {

    public Super() {
        // 생성자에서 재정의 가능 메서드 호출
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Super.overrideMe");
    }
}
