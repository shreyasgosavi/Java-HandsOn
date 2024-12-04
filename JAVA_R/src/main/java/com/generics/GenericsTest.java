package com.generics;

import java.util.ArrayList;

public class GenericsTest {


    public static void main(String[] args) {
        int minValue;

        ArrayList<?> arrList = new ArrayList<String>();

//        genericMethod(123);
//        genericMethod("123");
//        genericMethod(123.342);
//        genericMethod(true);

        ArrayList<? super Number> heyArray = new ArrayList<>();
        heyArray.add(2);

        ArrayList<? extends Integer> heyArray2 = new ArrayList<>();

        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(5);
        numberList.add(13);
        System.out.println("Final sum is "+getSumThroughGenerics(numberList));

    }

    public static <T> void genericMethod(T someObject){
        System.out.println("This accepts object of any type "+someObject.getClass().getSimpleName());
    }

    public static double getSumThroughGenerics(ArrayList<? extends Number> someCOllection){

        double sum = 0;
        for(Number n : someCOllection){
            sum += n.doubleValue();
        }

        return sum;
    }

    public static int findSmallest(int[] arr, int index, int minValue) {

        if(index == arr.length){
            return minValue;
        }

        if(arr[index] < minValue){
            minValue = arr[index];
        }
        return findSmallest(arr, ++index, minValue);

    }
}

class GenericClass<T> {

}
