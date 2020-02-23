package com.param.javacode.designpatterns.observer.inbuild;

import java.util.ArrayList;
import java.util.Observable;

public class JobsObservable extends Observable {


    ArrayList<String> jobsArrayList = new ArrayList<>();

    public JobsObservable(){ }


    public ArrayList<String> getJobsArrayList() {
        return jobsArrayList;
    }

    public void addnewJob(String jobname){
        jobsArrayList.add(jobname);
        setChanged();
        notifyObservers();
    }


}
