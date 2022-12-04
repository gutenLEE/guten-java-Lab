package studyexception;

/**
 * @author gutenlee
 * @since 2022/11/21
 */
public class ExceptionSample2 {
    public static void main(String[] args) {

        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(args[0]);
            System.out.println(4);
        } catch (ArithmeticException e){
            System.out.println("exception handling");
        }
        System.out.println(5);
    }
}
