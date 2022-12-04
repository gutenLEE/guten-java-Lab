package studyexception;

/**
 * @author gutenlee
 * @since 2022/11/21
 */
public class ExceptionSample1 {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            System.out.println(0 / 0);
            System.out.println(2);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException ");
        } catch (Exception e) {
            System.out.println("Exception ");
        }
        System.out.println(4);
    }
}
