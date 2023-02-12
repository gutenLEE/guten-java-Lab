package com.example.webflux.toby;

import reactor.core.publisher.Flux;

/**
 * @author gutenlee
 * @since 2023/02/12
 */
public class ReactorEx {

    public static void main(String[] args) {

        Flux.create(s -> {
            s.next(1);
            s.next(2);
            s.next(3);
            s.next(4);
        })
        .log()
        .subscribe(System.out::println);
    }
}
