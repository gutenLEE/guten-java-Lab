package com.example.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import java.util.*;

/**
 * @author gutenlee
 * @since 2022/09/05
 */
public class RetryWhenTest {

    @Test
    void test1() throws Exception {
        Flux.range(1, 3)
                .doOnNext(i -> System.out.println("Emitted :: " + i))
                .repeatWhen(flux -> flux.handle((lastEmitted, sink) -> {
                    if(lastEmitted > 3)
                        sink.complete();
                    else
                        sink.next(1);
                }))
                .subscribe(i -> System.out.println("Received :: " + i));

    }



    @Test
    void test() throws Exception {

        Queue<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Flux.generate(() -> list, (state, sink) -> {
            Integer poll = state.poll();
            sink.next(poll);
            return list;
        })
        .log("first published : ")
        .flatMap(r -> {
            if (r == Integer.valueOf(4))
                return Flux.error(new RuntimeException());
            return Flux.just((Integer) r*10);
        })
        .retry(2)
        .onErrorContinue((e, elm) -> {})
        .log("??")
        .subscribe();

    }

    @Test
    void using_defer() throws Exception {
        Flux.range(1, 10)
                .flatMap(l -> Flux.defer(() -> throwErrorWhen5(l))
                                                .retry(3)
                                                .onErrorReturn(l)
                )
                .subscribe(r -> {
                    System.out.println("Received " + r);
                });
    }

    public Flux<Integer> throwErrorWhen5(int val){
        if(val == 5){
            System.out.println("Hello Error in Five");
            return Flux.error(new RuntimeException("ERROR"));
        }
        return Flux.just(val);
    }

    @Test
    void flux_zip() throws Exception {
        Flux<Integer> queryResult_1 = Flux.range(1, 10);
        Flux<Integer> queryResult_2 = Flux.range(20, 36);

        Flux.zip(queryResult_1, queryResult_2)
                .collectList()
                .subscribe((tuple2s -> {
                    List<Integer> aList = new ArrayList<>();
                    List<Integer> bList = new ArrayList<>();
                    for (Tuple2<Integer, Integer> tuple2 : tuple2s) {
                        Integer t1 = tuple2.getT1();
                        Integer t2 = tuple2.getT2();
                        aList.add(t1);
                        bList.add(t2);
                    }
                    System.out.println("aList = " + aList);
                    System.out.println("bList = " + bList);
                }));
    }


}

