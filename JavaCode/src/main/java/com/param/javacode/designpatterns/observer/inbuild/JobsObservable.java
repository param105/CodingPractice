package com.param.javacode.designpatterns.observer.inbuild;

import java.util.ArrayList;
import java.util.Observable;

class JobsObservable extends Observable {


    ArrayList<String> jobsArrayList = new ArrayList<>();

    JobsObservable(){ }


    ArrayList<String> getJobsArrayList() {
        return jobsArrayList;
    }

    void addnewJob(String jobname){
        jobsArrayList.add(jobname);
        setChanged();
        notifyObservers();
    }


}
