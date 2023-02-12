package com.example.webflux.toby;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gutenlee
 * @since 2023/02/12
 */
public class SchedulerEx {

    // 가장 핵심적이고 기초적인 구현을 파악한 다음 직접 만들어 본다.
    // 표준을 잘 알아야한다.

    public static void main(String[] args) {

        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    sub.onNext(1);
                    sub.onNext(2);
                    sub.onNext(3);
                    sub.onNext(4);
                    sub.onComplete();
                }

                @Override
                public void cancel() {

                }
            });
        };

//        Publisher<Integer> subOnPub = sub -> {
//            ExecutorService es = Executors.newSingleThreadExecutor();
//            es.execute(() -> pub.subscribe(sub));
//        };

        Publisher<Integer> pubOnPub = sub -> {
            pub.subscribe(new Subscriber<Integer>() {
                ExecutorService es = Executors.newSingleThreadExecutor();
                @Override
                public void onSubscribe(Subscription s) {
                    sub.onSubscribe(s);
                }

                @Override
                public void onNext(Integer integer) {
                    es.execute(() -> sub.onNext(integer));
                }

                @Override
                public void onError(Throwable t) {
                    es.execute(() -> sub.onError(t));
                }

                @Override
                public void onComplete() {
                    es.execute(() -> sub.onComplete());
                }
            });
        };

        pubOnPub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("SchedulerEx.onSubscribe " );
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("SchedulerEx.onNext " + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("SchedulerEx.onComplete");
            }
        });

        System.out.println("exit");
    }
}
