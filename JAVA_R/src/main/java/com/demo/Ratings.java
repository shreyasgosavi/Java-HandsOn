package com.demo;

enum RatingsValues{

    Excellent,
    VeryGood,
    Good,
    CanBeBetter,
    NeedsImprovement

}

public class Ratings{

    private static RatingsValues rate;

    public static void main(String[] args) {

        RatingsValues rate = RatingsValues.CanBeBetter;

        System.out.println(rate.toString());

        switch(rate){
            case CanBeBetter:
                System.out.println("Wohhhu it needs to be good");
                break;
            case Good:
                System.out.println("Good amazing");
                break;
            default:
                System.out.println("Naah");

        }
    }
}

