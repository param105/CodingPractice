package com.param.javacode.designpatterns.observer.custom;

public class SubscriberSocialMedia implements CoronaVirusObserver{

    public SubscriberSocialMedia(CoronaVirusObservable observable) {
        observable.subscribe(this);
    }


    void displayCoronaPost(CoronaVirusObservable observable){
        CoronaVirusDataPublisher data = ((CoronaVirusDataPublisher)observable);

        System.out.println("@@@@@@@@@@ FACEBOOK VIRAL  POST @@@@@@@@@@");
        System.out.println("Infected -> "+data.getTotalInfectedCount());
        System.out.println("Deaths -> "+data.getTotalDeathCounts());
        System.out.println("Recovered -> "+data.getTotalRecovered());
        System.out.println("---------------------------------------------");

    }
    @Override
    public void update(CoronaVirusObservable observable) {
        displayCoronaPost(observable);
    }
}
