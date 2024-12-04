package com.threading.counter;

class Counter {

    int i = 0;

    void increment() {
        i++;
    }
}

public class TheadsAdding {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 100000; j++) {
                counter.increment();
                try {
                    Thread.sleep(500);
                }
                catch(Exception e){
                    System.out.println("Exception occured");
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t2 = new Thread(() -> {
//            for(int j=0;j<10;j++){
//                counter.increment();
            while (counter.i < 100000) {
                System.out.println("Value of I read by Thread 2 is " + counter.i);
            }
//            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (Exception e) {
            t1.interrupt();
        }

        try {
            t2.join();
        } catch (Exception e) {
            t2.interrupt();
        }


        System.out.println("Final count is " + counter.i);
    }
}
