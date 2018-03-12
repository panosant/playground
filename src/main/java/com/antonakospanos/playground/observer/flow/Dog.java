package com.antonakospanos.playground.observer.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class Dog implements Flow.Publisher {

    private String name;
    private int years;

    public Dog(String name, int years) {
        this.name = name;
        this.years = years;
    }

    List<Flow.Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
        notifySubscribers();
    }

    private void notifySubscribers() {
        subscribers.forEach(subscriber -> {
            subscriber.onNext(this);
        });
    }
}
