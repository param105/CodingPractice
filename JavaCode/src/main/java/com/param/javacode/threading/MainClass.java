package com.param.javacode.threading;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        ArrayList<Future<Double>> doubleFutureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10 ; i++) {
          //  executorService.submit(new TaskRunnable());
            Future<Double> doubleFuture = executorService.submit(new TaskCallable());
            doubleFutureList.add(doubleFuture);
        }

        for (Future<Double> val: doubleFutureList) {
            try {
                System.out.println("Future ->"+val.get() );
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

    /***
     *
     * Creates runnable task which can be added in threadpool
     */
    private static class TaskCallable implements Callable<Double> {
        @Override
        public Double call() {
            int i = 0;
            for ( i = 1; i < 5 ; i++) {
                atomicInteger.set(atomicInteger.get()+1);
                System.out.println(Thread.currentThread().getId() +"- Future - "+atomicInteger.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return (double) atomicInteger.get();
        }
    }

    /***
     * Creates runnable task which can be added in threadpool
     */
    private static class TaskRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getId() +"- Future - "+i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


