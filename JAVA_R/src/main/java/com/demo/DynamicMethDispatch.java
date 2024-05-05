package com.demo;

class Computer{

    public void process(){
        System.out.println("I am processing your request");
    }
}

class Laptop extends Computer{

    int a = 5;
    public void process(){
        a = 3;
        System.out.println("I am a laptop processing your request");
    }

//    public void advancedProcessing(){
//        System.out.println("Advanced Processing");
//    }

}


public class DynamicMethDispatch {

    public static void main(String[] args) {

        Computer computer = new Laptop();
        computer.process();
//        computer.advancedProcessing();
    }

}
