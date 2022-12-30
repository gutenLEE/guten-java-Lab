package effectivejava.item12;

/**
 * @author gutenlee
 * @since 2022/12/14
 */
public class Address {
    private final String detail;
    private final String street;
    private final String city;
    private final int zipCode;

    public Address(String detail, String street, String city, int zipCode) {
        this.detail = detail;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", detail, street, city, zipCode);
    }
}

