package com.param.javacode.designpatterns;

public class SingletonClass {

    //Private singleton object
    public static SingletonClass singletonClass;

    // Private method
    private SingletonClass() {
        // this is private
    }

    public SingletonClass(String name) {
        // this is private
    }

    // public factory method
    public static SingletonClass getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        System.out.println("Singleton instance sent to " + Thread.currentThread().getName());

        return singletonClass;
    }


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

    public void printPrimes() {
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

    public void printReverse() {
        System.out.println(Thread.currentThread().getName() + " - Out of Sync");
        synchronized (SingletonClass.this) {
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
}
