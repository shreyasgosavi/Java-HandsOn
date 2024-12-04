package com.threading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoExtLock {

    public void normalLock() {
        Lock lock = new ReentrantLock();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                int i = 0;

                while (i < 1000) {
                    if (i == 400) {
                        System.out.println("Thread - " + Thread.currentThread().getName() + " :: STATE " +
                                Thread.currentThread().getState());
                        lock.lock();
                        System.out.println("Thread : " + Thread.currentThread().getName() + " after getting access :: STATE " +
                                Thread.currentThread().getState());
                    } else if (i == 700) {
                        lock.unlock();
                    }
                    System.out.println(Thread.currentThread().getName());
                    i++;
                }
            }
        };

        Thread t1 = new Thread(run, "t1");
        Thread t2 = new Thread(run, "t2");
        Thread t3 = new Thread(run, "t3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            System.out.println("Interrupted " + e);

        }

        System.out.println("DONE");
    }

    int numberOne(){
        try{
            System.out.println("Inside fuction call");
            return 1;
        }
        finally{
            System.out.println("Returning a value");
        }
    }

    public static void main(String[] args) {

        DemoExtLock d = new DemoExtLock();
        int a = d.numberOne();

//        Lock lock = new ReentrantLock();
//
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//
//                while (i < 1000) {
//                    if (i == 400) {
//                        System.out.println("Thread " + Thread.currentThread().getName() + " :: STATE " +
//                                Thread.currentThread().getState());
//                        boolean isAccessed = lock.tryLock();
//                        System.out.println("Did thread "+Thread.currentThread().getName()+" get access : "+isAccessed);
//                        System.out.println("Thread " + Thread.currentThread().getName() + " after getting access :: STATE " +
//                                Thread.currentThread().getState());
//                    } else if (i == 700) {
//                        lock.unlock();
//                    }
//                    System.out.println(Thread.currentThread().getName());
//                    i++;
//                }
//            }
//        };
//
//        Thread t1 = new Thread(run, "t1");
//        Thread t2 = new Thread(run, "t2");
//        Thread t3 = new Thread(run, "t3");
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (Exception e) {
//            System.out.println("Interrupted " + e);
//
//        }
//
//        System.out.println("DONE");

    }

}




