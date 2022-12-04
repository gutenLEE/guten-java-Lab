package com.example.springlab.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author gutenlee
 * @since 2022/10/22
 */
public class CglibTest {
    @Test
    void introduction_to_cglib() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class);

        String result = new Cat().meow();
        System.out.println("result = " + result);

        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (method.getDeclaringClass().equals(Cat.class)
                && method.getReturnType().equals(String.class))
                    return "something else";
                else
                    return 10;
            }
        });
        Cat cat = (Cat) enhancer.create();
        System.out.println("cat = " + cat.meow());
        System.out.println("age = " + cat.age());

    }

    public static class Cat {
        public String meow(){
            return "meeeeeow";
        }

        public int age() {
            return 5;
        }
    }


}
