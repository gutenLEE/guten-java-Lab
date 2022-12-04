package com.example.springlab.proxy;

/**
 * @author gutenlee
 * @since 2022/10/24
 */
public class DummyPrinter {
    public void print1() {
        System.out.println("print1");
    }

    public void print2() {
        System.out.println("print2");
    }

    public void printBoth() {
        print1();
        print2();
    }
}
