package com.example.webflux.toby;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author gutenlee
 * @since 2022/08/09
 */
public class PubSub {

    // Iterable <---> Observable (duality)

    // observer pattern의 단점 1. complete, 2. error 
    public static void main(String[] args) {
        Iterable<Integer> itr = Arrays.asList(1,2,3,4,5,6,7,8);


        Publisher<Integer> publisher = s -> {
            Iterator<Integer> it = itr.iterator();

            s.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    while (true) {
                        if (it.hasNext())
                            s.onNext(it.next());
                        else
                        {
                            s.onComplete();
                            break;
                        }
                    }
                }

                @Override
                public void cancel() {

                }
            });
        };


        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("PubSub.onSubscribe");
                    s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("PubSub.onNext " + integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("PubSub.onError");
            }

            @Override
            public void onComplete() {
                System.out.println("PubSub.onComplete");
            }
        };

        publisher.subscribe(subscriber);

    }
}
