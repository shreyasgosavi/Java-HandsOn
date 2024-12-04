package com.threading;

public class PrintHello {

    public static void main(String[] args) {

        PrintWorld printWorld = new PrintWorld();
        printWorld.start();
        /*
        Throws Illegal-Thread-State-Exception as Thread in java is one-time executable and starts
        only if it's in NEW state
        */
//        printWorld.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello!");
        }
    }
}
