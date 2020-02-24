package com.param.javacode.designpatterns.observer.custom;

public class MainClass {
    private CoronaVirusDataPublisher publisher;
    /// fake data to test
    private CoronaPojo[] testCoronadata = new CoronaPojo[]{
            new CoronaPojo(100, 1, 1),
            new CoronaPojo(200, 2, 2),
            new CoronaPojo(300, 3, 3),
            new CoronaPojo(400, 4, 4),

    };


    /***
     * Constructor we are just initializing objects here
     */
    private MainClass(){
        publisher = new CoronaVirusDataPublisher();
        new SubscriberNewsChannel(publisher);
        new SubscriberSocialMedia(publisher);
    }

    /***
     *   adds fake data to publisher with delay
     */
    private void startAddingTestData(){
        new Thread(() -> {
            for (CoronaPojo data:testCoronadata) {
                publisher.setData(data);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /***
     * main method to run to check the result
     * @param args
     */
    public static void main(String[] args) {
        new MainClass().startAddingTestData();

    }
}
