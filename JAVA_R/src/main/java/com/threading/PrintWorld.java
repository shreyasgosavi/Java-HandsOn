package com.threading;

public class PrintWorld extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            System.out.println("World");
        }
    }
}


