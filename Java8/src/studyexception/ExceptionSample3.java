package studyexception;

/**
 * @author gutenlee
 * @since 2022/11/21
 */
public class ExceptionSample3 {
    public static void main(String[] args) {

        try {
            throwException();
        } catch (ExceptionA | ExceptionB e) {

            if (e instanceof ExceptionA) {
                ExceptionA eA = (ExceptionA) e;
                eA.methodA();
            }
        }

    }

    public static void throwException(){
        throw new ExceptionA();
    }
}
