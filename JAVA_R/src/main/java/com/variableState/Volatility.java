package com.variableState;

public class Volatility {

    boolean varFlag = false;

    void changeFlagToTrue(){
        varFlag = true;
    }

    boolean getBooleanValue(){
        return varFlag;
    }

    public static void main(String[] args) {

        Volatility volatility = new Volatility();

        Thread t1 = new Thread(()->{
            while(!volatility.varFlag){
//                System.out.println("Waiting");
            }
            System.out.println("Flag is finally true");
        });

        Thread t2 = new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("Interrupted !!");
                Thread.currentThread().interrupt();
            }
           volatility.changeFlagToTrue();
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.out.println("Interrupted !!");
            if(t1.isInterrupted()){
                t1.interrupt();
            }
            if(t2.isInterrupted()){
                t2.interrupt();
            }
        }

    }

}
