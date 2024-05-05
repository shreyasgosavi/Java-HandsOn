package com.demo;

class SuperParentClass {
    public SuperParentClass() {
        System.out.println("Super Parent is initialised");
    }
}

abstract class Sample extends SuperParentClass{
    static{
        System.out.println("Class loaded");
    }
    public abstract void someMethod();
    public Sample(){
        System.out.println("Object created");
    }
}

class JustChecking{

    public JustChecking() {
        Sample anotherSample = new Sample() {
            @Override
            public void someMethod() {
                System.out.println("This is inner class inside JustChecking");
            }
        };
        anotherSample.someMethod();
    }


}

public class InnerClasses {

    public static void main(String[] args) {
//        Class.forName("com.demo.Sample");
       Sample sample = new Sample(){
            @Override
            public void someMethod() {
                System.out.println("Over-riding this method");
            }
        };

       sample.someMethod();

       new JustChecking();

    }


}
