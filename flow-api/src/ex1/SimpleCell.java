package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

/**
 * @author yhlee
 * @since 2022-01-23 오후 10:27
 */
public class SimpleCell implements Flow.Publisher<Integer>, Flow.Subscriber<Integer> {
    private int value = 0;
    private String name;
    private List<Subscriber> subscribers = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(this.value));
    }

    @Override
    public void onSubscribe(Subscription subscription) {

    }


    @Override
    public void onNext(Integer item) {
        this.value = item;
        System.out.println(this.name + ":" + this.value);
        notifyAllSubscribers();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
