package effectivejava.item19;

/**
 * @author gutenlee
 * @since 2023/01/17
 */
public class Suv extends Car {

    private int gas;

    public Suv(int gas) {
        super();
        this.gas = gas;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        gas = 100_000;
        return super.clone();
    }


    @Override
    public String toString() {
        return "Suv{" +
                "gas=" + gas +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Suv suv = new Suv(100);
        Suv clone = (Suv) suv.clone();
        System.out.println("clone = " + clone);
    }


}
