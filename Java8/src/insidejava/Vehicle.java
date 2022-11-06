package insidejava;

/**
 * @author gutenlee
 * @since 2022/11/01
 */
public class Vehicle {
    static {
        System.out.println("#### 1 ####");
    };
    {
        System.out.println("### 4 ###");
    };
    public Vehicle(){
        System.out.println("### 5 ###");
    }
}
