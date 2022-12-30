package effectivejava.item12;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author gutenlee
 * @since 2022/12/13
 */
public class Tester {

    public static void main(String[] args) {

        PhoneNumber phoneNumber = new PhoneNumber();
//        System.out.println("phoneNumber = " + phoneNumber);


//        System.out.println(phoneNumber);

//        System.out.printf("%s", phoneNumber);

        BigInteger bigInteger = new BigInteger("123123123123");

        BigDecimal bigDecimal = new BigDecimal("12.12");


        Address address = new Address("123", "성동구 연무장길", "서울", 11111);


        System.out.println("address = " + address);



        if (address == null) {
            System.out.println();
        }
    }


}
