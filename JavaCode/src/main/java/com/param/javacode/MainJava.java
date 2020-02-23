package com.param.javacode;

import com.param.javacode.designpatterns.singleton.SingletonClass;

public class MainJava {

    public static void main(String[] args) {
        System.out.println("Main launched..");

        /***
         * Demo of
         */
        final Runnable runnable1 = () -> SingletonClass.getInstance().printNumbers();
        final Runnable runnable2 = () -> SingletonClass.getInstance().printPrimes();
        final Runnable runnable3 = () -> SingletonClass.getInstance().printReverse();

        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();



    }

}
