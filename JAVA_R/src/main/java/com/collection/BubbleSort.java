package com.collection;

import java.util.Arrays;

public class BubbleSort{

    public static int[] bubbleSort(int[] someArray){

        int lastIndex = someArray.length-1;
        int startIndex = 0;

        while(startIndex < lastIndex){

            for(int i=0; i < lastIndex; i++){
                if(someArray[i] > someArray[i+1]){
                    int temp = someArray[i+1];
                    someArray[i+1] = someArray[i];
                    someArray[i]= temp;
                }
            }
            lastIndex--;
        }
        return someArray;

    }


    public static void main(String[] args){

        int[] someArray= {4,5,2,1,6,3,10};
        Arrays.stream(bubbleSort(someArray)).forEach((a)-> System.out.println(a));


    }


}
