package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Execut {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(Execut::count);
        executorService.shutdown();
    }

    public static void count(){
        for(int i = 0 ; i<= 10; i++){
            System.out.println(i);
        }
    }




}
