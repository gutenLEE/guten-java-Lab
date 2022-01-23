package ex1;

/**
 * @author yhlee
 * @since 2022-01-23 오후 10:40
 */
public class ArithmeticCell extends SimpleCell{
    private int left;
    private int right;

    public ArithmeticCell(String name) {
        super(name);
    }

    public void setLeft(int left) {
        this.left = left;
        onNext(left + this.right);
    }

    public void setRight(int right) {
        this.right = right;
        onNext(right + this.right);
    }
}
