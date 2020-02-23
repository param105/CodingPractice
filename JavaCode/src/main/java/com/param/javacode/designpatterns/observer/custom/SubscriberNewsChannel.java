package com.param.javacode.designpatterns.observer.custom;

public class SubscriberNewsChannel implements CoronaVirusObserver {

    /**
     * @param observable
     */
    SubscriberNewsChannel(CoronaVirusObservable observable) {
        observable.subscribe(this);
    }


    private void displayCoronaNews(CoronaVirusObservable observable){
        CoronaVirusDataPublisher data = ((CoronaVirusDataPublisher)observable);

        System.out.println("#############    AAJ TAK   #################");
        System.out.println("############# BREAKING NEWS #################");
        System.out.println("Infected -> "+data.getTotalInfectedCount());
        System.out.println("Deaths -> "+data.getTotalDeathCounts());
        System.out.println("Recovered -> "+data.getTotalRecovered());
        System.out.println("---------------------------------------------");

    }
    @Override
    public void update(CoronaVirusObservable observable) {
        displayCoronaNews(observable);
    }

}
