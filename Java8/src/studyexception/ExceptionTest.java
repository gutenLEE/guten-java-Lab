package studyexception;

/**
 * @author gutenlee
 * @since 2022/11/23
 */
public class ExceptionTest {

    public static void main(String[] args) {
        step1();
    }

    public static void step1(){
        step2();
    }

    public static void step2(){
        step3();
    }

    public static void step3(){
        throw new RuntimeException("step 3 exception");
    }

}
