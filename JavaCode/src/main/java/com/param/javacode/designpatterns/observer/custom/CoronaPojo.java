package com.param.javacode.designpatterns.observer.custom;

public class CoronaPojo {

    private int totalInfectedCount;
    private int totalDeathCounts;
    private int totalRecovered;

    CoronaPojo(int totalInfectedCount, int totalDeathCounts, int totalRecovered) {
        this.totalInfectedCount = totalInfectedCount;
        this.totalDeathCounts = totalDeathCounts;
        this.totalRecovered = totalRecovered;
    }


    int getTotalInfectedCount() {
        return totalInfectedCount;
    }

    public void setTotalInfectedCount(int totalInfectedCount) {
        this.totalInfectedCount = totalInfectedCount;
    }

    int getTotalDeathCounts() {
        return totalDeathCounts;
    }

    public void setTotalDeathCounts(int totalDeathCounts) {
        this.totalDeathCounts = totalDeathCounts;
    }

    int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }


}
