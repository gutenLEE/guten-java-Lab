package insidejava;

/**
 * @author gutenlee
 * @since 2022/11/01
 */
public class Civic extends Honda {
    static {
        System.out.println("#### 3 ####");
    };
    public Civic(){
        System.out.println("### 9 ###");
    }
    {
        System.out.println("### 8 ###");
    };
    public void model(){
        System.out.println("### 10 ###");
    }
}
