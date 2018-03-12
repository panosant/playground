package com.antonakospanos.playground.observer.flow;

import java.util.concurrent.Flow;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class George implements Flow.Subscriber {

    private String name;
    private Dog dog;
    private int parties;

    public George(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
        dog.subscribe(this);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed to: " + subscription);
    }

    @Override
    public void onNext(Object item) {
        Dog dog = (Dog) item;
        celebrateDogBirthday(dog.getYears());
    }

    private void celebrateDogBirthday(int birthday) {
        System.out.println("... Party ..!");
        this.parties = birthday;
    }

    public int getParties() {
        return parties;
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
