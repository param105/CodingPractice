package com.param.javacode.designpatterns.observer.custom;

class CoronaVirusDataPublisher implements CoronaVirusObservable {

    private CoronaPojo currentCoronaData ;

    void setData(CoronaPojo coronaUpdatedData) {
        currentCoronaData = coronaUpdatedData;
        notifyObservers();
    }


    int getTotalInfectedCount() {
        return currentCoronaData.getTotalInfectedCount();
    }

    int getTotalDeathCounts() {
        return currentCoronaData.getTotalDeathCounts();
    }

    int getTotalRecovered() {
        return currentCoronaData.getTotalRecovered();
    }



}
