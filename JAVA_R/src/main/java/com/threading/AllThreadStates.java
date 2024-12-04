package com.threading;

public class AllThreadStates extends Thread{

    @Override
    public void run() {
        System.out.println("Running is running independently");

        try {
            Thread.sleep(3000);
            System.out.println("Comeback  :: STATE :: "+Thread.currentThread().getState() );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {

        //Daemon thread that displays time
        DaemonTimeThread dt = new DaemonTimeThread();
        dt.setDaemon(true);
        dt.start();

        System.out.println("Started main thread");
        AllThreadStates ats = new AllThreadStates();
//        ats.setDaemon(true);
        System.out.println("AllThreadIsCreated its state :: STATE :: "+ats.getState());

        ats.start();
        System.out.println("AllThreadIsCreated is started with start() :: STATE :: "+ats.getState());

        try {
            Thread.sleep(100);
            System.out.println("ATS is waiting its state :: STATE :: "+ats.getState());
//            ats.join();
            System.out.println("ATS exeecution completed :: STATE :: "+ats.getState());
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
        System.out.println("END");

    }

}