package com.param.javacode.designpatterns.observer.custom;

import java.util.ArrayList;

public interface CoronaVirusObservable{

    ArrayList<CoronaVirusObserver> observers = new ArrayList<>();

    default void subscribe(CoronaVirusObserver observer){
        observers.add(observer);
    }

    default void unSubscribe(CoronaVirusObserver observer) {
        observers.remove(observer);
    }

    default void notifyObservers(){
        for (CoronaVirusObserver o:observers) {
            o.update(this);
        }
    }
}
