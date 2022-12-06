package effectivejava.item1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BlockingDeque;

/**
 * @author gutenlee
 * @since 2022/12/04
 */
public class StaticFactoryMethod {
    public static void main(String[] args) {

        System.out.println("boolByConstructor vs boolByStaticFactoryMethod");
        for (int i = 0; i < 100; i++) {
            Boolean boolByConstructor = new Boolean(true);
            Boolean boolByStaticFactoryMethod = Boolean.valueOf(true);

            System.out.printf(
                    "%10d || %10d \n",
                    System.identityHashCode(boolByConstructor),
                    System.identityHashCode(boolByStaticFactoryMethod)
            );
        }

    }
}
