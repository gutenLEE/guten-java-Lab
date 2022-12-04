package com.example.springlab.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterProxyTest {

    @Test
    void proxy_test() throws Exception {
        DummyPrinter p = new PrinterProxy();
        p.printBoth();
    }


}