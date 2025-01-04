package com.leetCode;

public class QuickSort {


    public static void quickIt(int[] arr, int low, int high){

        if(low<high){

            int pivot = high;
            int setPosition=low,scanArray=low;

            while(scanArray < pivot){

                if(arr[scanArray] < arr[pivot]){
                    int temp = arr[setPosition];
                    arr[setPosition] = arr[scanArray];
                    arr[scanArray] = temp;
                    setPosition++;
                }
                scanArray++;
            }

            int temp = arr[pivot];
            arr[pivot] = arr[setPosition];
            arr[setPosition] = temp;

            quickIt(arr,low, setPosition-1);
            quickIt(arr, setPosition+1, high);
        }

//        System.out.println(arr);
    }


    public static void main(String[] args) {

        int[] randomArray={5,1,5,7,2,7,3,2};

        quickIt(randomArray,0 , randomArray.length-1);
        System.out.println(randomArray);


    }
}
