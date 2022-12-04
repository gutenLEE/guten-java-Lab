package studyexception;

/**
 * @author gutenlee
 * @since 2022/11/21
 */
public class ExceptionA extends RuntimeException{
    public void methodA(){
        System.out.println("exception A handle ");
    }
}
