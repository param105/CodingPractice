package com.param.javacode.designpatterns.observer.inbuild;

import java.util.Observable;
import java.util.Observer;

public class JobsObserverOne implements Observer {
    Observable observable;
    String[] jobs;


    public JobsObserverOne(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    private void displayAllJobs(Object o) {
        jobs = ((JobsObservable) observable).getJobsArrayList().toArray(new String[0]);
        System.out.println("######### Updated Job List received in observer ONE ######");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] +",");
        }
        System.out.println();
    }


    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof JobsObservable) {
            displayAllJobs(o);
        }
    }


}
