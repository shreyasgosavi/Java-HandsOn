package com.demo;

class Scorpio extends Car{

    @Override
    public void ingition() {
        System.out.println("Igniting");
    }

    @Override
    public void race() {
        System.out.println("Increasing speed");
    }
}

class Liva extends Car{

    @Override
    public void ingition() {
        System.out.println("Liva stated");
    }

    @Override
    public void race() {
        System.out.println("Racing out smoothly");
    }
}


public class AbstractConcept {

    public static void main(String[] args) {
        System.out.println("Running");
    }

}
