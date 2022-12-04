package proxypattern;

/**
 * @author gutenlee
 * @since 2022/10/05
 */
public class ProxyTester {
    public static void main(String[] args) {
        ExpensiveObjectProxy objectProxy = new ExpensiveObjectProxy();
        objectProxy.process();
        objectProxy.process();
    }
}
