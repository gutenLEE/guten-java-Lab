package com.example.bestpricefinderapi.domain;

/**
 * @author yhlee
 * @since 2022-01-25 오전 9:55
 */
public class Shop {
    public double getPrice(String product){
        // to query the shop's database
        // to contact other external services
        return 0.f;
    }

    // fake a long-running method execution
    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
