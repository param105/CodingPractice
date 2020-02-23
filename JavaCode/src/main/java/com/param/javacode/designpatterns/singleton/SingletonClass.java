package com.param.javacode.designpatterns.singleton;

public class SingletonClass {

    //Private singleton object
    private static SingletonClass singletonClass;

    // Private method
    private SingletonClass() {
        // this is private
    }

    // public factory method
    public static SingletonClass getInstance() {
        if (singletonClass == null) {
            synchronized (SingletonClass.class) {
                if (singletonClass == null) {
                    singletonClass = new SingletonClass();
                }
            }
        }
        System.out.println("Singleton instance sent to " + Thread.currentThread().getName());

        return singletonClass;
    }


    /***
     * to print numbers
     * object level locks are applied here so that only one thread can enter
     */
    public void printNumbers() {
        System.out.println(Thread.currentThread().getName() + " - Out of Sync");
        synchronized(SingletonClass.this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }


    }

    /***
     * prints odds but only single thread can operate on this method
     */
    public void printOdds() {
        System.out.println(Thread.currentThread().getName() + " - Out of Sync");
        synchronized (SingletonClass.this) {
            for (int i = 1; i <= 20; i += 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }

    }

    /***
     * No locking so many threads can operate on this
     */
    public void printReverse() {
        System.out.println(Thread.currentThread().getName() + " - Out of Sync");
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }

    }
}
