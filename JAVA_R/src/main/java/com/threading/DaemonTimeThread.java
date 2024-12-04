package com.threading;

import java.util.Date;

public class DaemonTimeThread extends Thread{

    @Override
    public void run() {
        while(true){
            Date date = new Date();
            System.out.println("Current date is "+date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error re baba");
            }
        }
    }
}
