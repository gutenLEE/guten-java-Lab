package proxypattern;

import lombok.NoArgsConstructor;

/**
 * @author gutenlee
 * @since 2022/10/05
 */
public class ExpensiveObjectImpl implements ExpensiveObject{

    public ExpensiveObjectImpl() {
        headyInitialConfiguration();
    }

    @Override
    public void process() {
        System.out.println("processing complete");
    }

    private void headyInitialConfiguration(){
        System.out.println("Loading initial configuration...");
    }
}
