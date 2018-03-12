package com.antonakospanos.playground.observer.custom;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public interface Observable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers();
}
