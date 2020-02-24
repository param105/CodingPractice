package com.param.javacode.designpatterns.observer.inbuild;

/***
 * Class demonstrates how to use inbuilt java observable and observer design pattern
 */
public class MainClass {

    private String[] testJobs ={"Android","Java","IOS","Node","Flutter","React-Native"};
    private JobsObservable jobsObservable;

    private MainClass(){
        jobsObservable = new JobsObservable();
        new JobsObserverOne(jobsObservable);
        new JobsObserverTwo(jobsObservable);
    }

    private void startAddingTestJobs(){
        //Lets add some jobs in the observable class.
        // following thread will add new jobs after some delay

        new Thread(() -> {
            for (String testJob : testJobs) {

                jobsObservable.addnewJob(testJob);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    public static void main(String[] args) {
        new MainClass().startAddingTestJobs();
    }
}
