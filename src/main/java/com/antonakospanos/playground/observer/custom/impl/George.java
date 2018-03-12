package com.antonakospanos.playground.observer.custom.impl;

import com.antonakospanos.playground.observer.custom.Observable;
import com.antonakospanos.playground.observer.custom.Observer;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class George implements Observer {

    private String name;
    private Dog dog;
    private int parties;

    public George(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
        dog.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        Dog dog = (Dog) observable;

        celebrateDogBirthday(dog.getYears());
    }

    public int getParties() {
        return parties;
    }

    private void celebrateDogBirthday(Integer years) {
        System.out.println("... Party ..!");
        this.parties = years;
    }
}








