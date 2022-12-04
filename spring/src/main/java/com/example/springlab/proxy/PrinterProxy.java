package com.example.springlab.proxy;

/**
 * @author gutenlee
 * @since 2022/10/24
 */
public class PrinterProxy extends DummyPrinter {
    @Override
    public void print1() {
        System.out.println(this + " Before print1");
        super.print1();
    }

    @Override
    public void print2() {
        System.out.println(this + " Before print2");
        super.print2();
    }

    @Override
    public void printBoth() {
        System.out.println(this + " Before print both");
        super.printBoth();
    }
}
