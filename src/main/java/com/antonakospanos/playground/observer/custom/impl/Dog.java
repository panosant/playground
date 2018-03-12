package com.antonakospanos.playground.observer.custom.impl;



import com.antonakospanos.playground.observer.custom.Observable;
import com.antonakospanos.playground.observer.custom.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class Dog implements Observable {

    private String name;
    private int years;
    private List<Observer> observers = new ArrayList<>();

    public Dog(String name, int years) {
        this.name = name;
        this.years = years;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.update(this);
        });
    }
}
