package com.threading.executer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecuterss {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(
                ()-> System.out.println("Here we go !!"),
                4,
                TimeUnit.SECONDS
        );
        scheduledExecutorService.shutdown();

        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
        scheduledExecutorService2.scheduleAtFixedRate(
                ()-> System.out.println("Here we goo again !!"),
                3,
                5,
                TimeUnit.SECONDS
        );
        scheduledExecutorService2.shutdown();


    }
}
