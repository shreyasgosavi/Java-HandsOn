package com.threading;

public class MainTEst {

    public void functionCall() throws InterruptedException {
        System.out.println("Function called by "+Thread.currentThread().getName());
        System.out.println("Function called by "+Thread.currentThread().getState());
        Thread.sleep(2000);
        System.out.println("After halting for 2 secs");
        anotherFunction();
        System.out.println("Thread state is "+Thread.currentThread().getState());
    }

    public void anotherFunction() throws InterruptedException {

        System.out.println("Another function call");
        Thread.sleep(2000);
        System.out.println("another Function called "+Thread.currentThread().getName());

    }




    public static void main(String[] args) {

        MainTEst mt = new MainTEst();
        System.out.println("Thread is "+Thread.currentThread().getName());

        try {
            mt.functionCall();
        }
        catch(Exception e){

        }
    }
}
