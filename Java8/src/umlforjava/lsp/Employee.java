package umlforjava.lsp;

/**
 * @author gutenlee
 * @since 2023/01/12
 */
public abstract class Employee {
    abstract double calcPay() throws UnpayableEmployeeException;
}
