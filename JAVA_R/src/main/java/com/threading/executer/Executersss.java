package com.threading.executer;

import java.util.concurrent.*;

public class Executersss {

    public static void main(String[] args) {

        Runnable someRandomTask = () -> {
            try {
                System.out.println("This is the task by :: " + Thread.currentThread().getName());
                Thread.sleep(100);
                System.out.println("Task completed");
            }
            catch(Exception e){
                Thread.currentThread().interrupt();
            }

        };

        ScheduledExecutorService sch = Executors.newScheduledThreadPool(1);
        sch.scheduleAtFixedRate(()-> System.out.println("he"), 3,5,TimeUnit.SECONDS);

        ExecutorService executers = Executors.newFixedThreadPool(2);
        try {

            for (int i = 0; i < 10; i++) {
                Future<?> finall = executers.submit(someRandomTask);

                System.out.println("Result for "+Thread.currentThread().getName()+" is " + finall.get());
            }
            System.out.println("Is task complete " + executers.isShutdown());
            executers.shutdown();


            executers.awaitTermination(1, TimeUnit.DAYS);
        } catch (Exception e) {
            System.out.println("Some thread interruption occured");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Some cleanUp task");
        }
    }


}
