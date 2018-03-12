package com.antonakospanos.playground.observer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class Executor {

    private static final String ownerName = "George";
    private static final String dogName = "Blanco";
    private static final AtomicInteger dogYears = new AtomicInteger(0);

    public static void main(String[] args) {
        flowObserver();
        customObserver();
        propertyObserver();
    }

    private static void flowObserver() {
        com.antonakospanos.playground.observer.flow.Dog dog = new com.antonakospanos.playground.observer.flow.Dog(dogName, dogYears.get());
        com.antonakospanos.playground.observer.flow.George george = new com.antonakospanos.playground.observer.flow.George(ownerName, dog);

        dog.setYears(dogYears.incrementAndGet());
        System.out.println(george.getParties());
    }

    private static void customObserver() {
        com.antonakospanos.playground.observer.custom.impl.Dog dog = new com.antonakospanos.playground.observer.custom.impl.Dog(dogName, dogYears.get());
        com.antonakospanos.playground.observer.custom.impl.George george = new com.antonakospanos.playground.observer.custom.impl.George(ownerName, dog);

        dog.setYears(dogYears.incrementAndGet());
        System.out.println(george.getParties());
    }

    private static void propertyObserver() {
        com.antonakospanos.playground.observer.property.Dog dog = new com.antonakospanos.playground.observer.property.Dog(dogName, dogYears.get());
        com.antonakospanos.playground.observer.property.George george = new com.antonakospanos.playground.observer.property.George(ownerName, dog);

        dog.setYears(dogYears.incrementAndGet());
        System.out.println(george.getParties());
    }
}
