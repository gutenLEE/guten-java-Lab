package insidejava;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CustomClassLoaderTest {

    @Test
    void test() throws Exception {
        CustomClassLoader ccl = new CustomClassLoader(CustomClassLoader.class.getClassLoader());
        System.out.println("===Inside ClassLoader===");
        Class<?> clazz = ccl.loadClass("insidejava.Utility");
        Object ob = clazz.getDeclaredConstructor().newInstance();
        Method m1 = clazz.getMethod("print");
        m1.invoke(ob);
        Civic civic = new Civic();
        civic.model();
    }

}