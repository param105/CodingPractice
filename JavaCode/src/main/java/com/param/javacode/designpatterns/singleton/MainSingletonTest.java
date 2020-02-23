package com.param.javacode.designpatterns.singleton;

public class MainSingletonTest {

    public static void main(String[] args) {
        /***
         * Demo of
         */
        final Runnable runnable1 = () -> SingletonClass.getInstance().printNumbers();
        final Runnable runnable2 = () -> SingletonClass.getInstance().printOdds();
        final Runnable runnable3 = () -> SingletonClass.getInstance().printReverse();

        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();


    }
}
