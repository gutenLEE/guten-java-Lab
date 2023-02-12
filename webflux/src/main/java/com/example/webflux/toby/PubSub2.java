package com.example.webflux.toby;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gutenlee
 * @since 2023/02/12
 *
 *
 *
 * Publisher -> Data1 -> map -> Data2 -> Subscriber(logSub)
 *
 */



public class PubSub2 {
    public static void main(String[] args) {

        Publisher<Integer> pub = iterPub(Stream.iterate(1, a->++a).limit(100)
                .collect(Collectors.toList()));

//        Publisher<Integer> mapPub = mapPub(pub, (Function<Integer, Integer>) s -> s*10);
//        Publisher<String> mapPub = mapPub(pub, s -> "[" + s + "]");
//        Publisher<Integer> mapPub2 = mapPub(mapPub, (Function<Integer, Integer>) s -> -s);
//        Publisher<Integer> sumPub = sumPub(pub);
        Publisher<String> reducePub = reducePub(pub, "", (BiFunction<String, Integer, String>) (a, b)->a+b);
        reducePub.subscribe(logSub());

    }

    private static <T, R> Publisher<R> reducePub(
            Publisher<T> pub,
            R initValue,
            BiFunction<R, T, R> reduceOperator
    ) {

        return new Publisher<>() {
            @Override
            public void subscribe(Subscriber<? super R> s) {

                pub.subscribe(new DelegateSub<T, R>(s) {
                    R result = initValue;

                    @Override
                    public void onNext(T value) {
                        result = reduceOperator.apply(result, value);
                    }

                    @Override
                    public void onComplete() {
                        s.onNext(result);
                        super.onComplete();
                    }
                });
            };
        };
    }

//    private static Publisher<Integer> sumPub(Publisher<Integer> pub) {
//        return new Publisher<Integer>() {
//            @Override
//            public void subscribe(Subscriber<? super Integer> sub) {
//                pub.subscribe(new DelegateSub(sub){
//                    int sum = 0;
//                    @Override
//                    public void onNext(Integer integer) {
//                        sum += integer;
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        sub.onNext(sum);
//                        sub.onComplete();
//                    }
//                });
//            }
//        };
//    }

    // T -> R
    private static <T,R> Publisher<R> mapPub(Publisher<T> pub, Function<T, R> mapFunction) {

        return new Publisher<R>() {
            @Override
            public void subscribe(Subscriber<? super R> s) {
                pub.subscribe(new DelegateSub<T,R>(s) {
                    @Override
                    public void onNext(T i) {
                        s.onNext(mapFunction.apply(i));
                    }
                });
            }
        };
    }

    private static <T> Subscriber<T> logSub() {
        return new Subscriber<>() {

            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
                System.out.println("PubSub2.onSubscribe ");
            }

            @Override
            public void onNext(T integer) {
                System.out.println("PubSub2.onNext " + integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("PubSub2.onError " + t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("PubSub2.onComplete");
            }
        };
    }

    private static Publisher<Integer> iterPub(Iterable<Integer> iter) {
        return sub -> sub.onSubscribe(new Subscription() {

            @Override
            public void request(long n) {
                iter.forEach(sub::onNext);
                sub.onComplete();
            }

            @Override
            public void cancel() {

            }
        });
    }
}
