package studyexception;

/**
 * @author gutenlee
 * @since 2022/11/21
 */
public class ExceptionB extends RuntimeException{
    public void methodB(){
        System.out.println("exception B handle ");
    }
}
