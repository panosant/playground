package com.antonakospanos.playground.observer.property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class George implements PropertyChangeListener {

    private String name;
    private Dog dog;
    private int parties;

    public George(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
        dog.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        int birthday = (Integer) event.getNewValue();

        celebreateDogBirthday(birthday);
    }

    private void celebreateDogBirthday(Integer birthday) {
        System.out.println("... Party ..!");
        this.parties = birthday;
    }

    public int getParties() {
        return parties;
    }
}
