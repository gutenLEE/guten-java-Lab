package com.example.webflux.operator;

import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;


public class ConcatVsFlatMap {
    public static void main(String[] args) {
        Car a = new Car();
        a.setColor("red");
        a.setSeq(1);

        Car b = new Car();
        b.setColor("blue");
        b.setSeq(2);

        Car c = new Car();
        c.setColor("yellow");
        c.setSeq(3);

        List<Car> list = List.of(a, b, c);
        Flux.fromIterable(list)
                .reduce(Flux.empty(), (accFlux, car) -> {
                    return Flux.merge(accFlux, Flux.just(car));
                })
                .subscribe(rr -> {
                    rr.subscribe(System.out::println);
                });


    }
}
