package com.example.webflux.toby;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author gutenlee
 * @since 2023/02/12
 */
public class FluxScEx {
    public static void main(String[] args) {

        Flux.range(1, 10)
            .publishOn(Schedulers.newSingle("pub"))
            .log()
            .subscribeOn(Schedulers.newSingle("sub"))
            .subscribe(System.out::println);
    }
}
