package com.collection;

import java.util.*;

public class Maps {

    public static void main(String[] args) {


//        HashMap<Integer, String> cricketers = new HashMap();
        Hashtable<Integer, String> cricketers = new Hashtable<>();

        cricketers.put(1,"Shreyas Gosavi");
        cricketers.put(2,"Shubham Gosavi");
        cricketers.put(3,"Virat Kohli");

//        String s = cricketers.get(2);
//
//        for(int i : cricketers.keySet()){
//            System.out.println("Player NUmber "+i+" is "+cricketers.get(i));
//        }
//
//        for(Map.Entry<Integer,String> entry : cricketers.entrySet()){
//            System.out.println("Player NUmber "+entry.getKey()+" is "+entry.getValue());
//        }

        Thread firstThread = new Thread(()->{

            for(int i=0; i<1000;i++){
                cricketers.put(i,"Player "+i);
            }

        });
        Thread secondThread = new Thread(()->{

            for(int i=1000; i<2000;i++){
                cricketers.put(i,"Player "+i);
            }

        });

        try {
            firstThread.start();
            secondThread.start();
            firstThread.join();
            secondThread.join();
        }
        catch(InterruptedException interruptedException){
            System.out.println("Thread interrupted for some reason");
            if(firstThread.isInterrupted()) {
                firstThread.interrupt();
            }
            if(secondThread.isInterrupted()) {
                firstThread.interrupt();
            }
        }

        System.out.println("Final hashmap size "+cricketers.size());
        System.out.println("1997th player "+cricketers.get(1997));

    }
}
