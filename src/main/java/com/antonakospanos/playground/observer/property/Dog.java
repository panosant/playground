package com.antonakospanos.playground.observer.property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by antonakospanos on 12/03/2018.
 */
public class Dog {

    private String name;
    private int years;

    private static PropertyChangeSupport support;

    public Dog(String name, int years) {
        this.name = name;
        this.years = years;
        this.support = new PropertyChangeSupport(this);
    }

    public void setYears(int years) {
        support.firePropertyChange("years", this.years, years); // before setting the new value!
        this.years = years;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
