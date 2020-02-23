package com.param.javacode.designpatterns.observer.inbuild;

import java.util.Observable;
import java.util.Observer;

public class JobsObserverOne implements Observer {
    JobsObservable jobsObservable;
    String[] jobs;


    public JobsObserverOne(JobsObservable observable) {
        this.jobsObservable = observable;
        observable.addObserver(this);
    }

    private void displayAllJobs(Object o) {
        jobs = jobsObservable.getJobsArrayList().toArray(new String[0]);
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
