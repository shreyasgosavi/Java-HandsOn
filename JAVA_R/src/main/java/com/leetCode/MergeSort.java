package com.leetCode;

public class MergeSort {

    public static int[] mergeSort(int arr[], int start,int end){

        if(start != end) {

            int mid = (start+end)/2;
            int[] firstHalf = mergeSort(arr, start, mid);
            int[] secondHalf =  mergeSort(arr, mid+1, end);

            int[] mergedArray = new int[firstHalf.length + secondHalf.length];


            int i=0,j=0;
            int begin=0;
            while(true){

                if(firstHalf[i] < secondHalf[j]){
                    mergedArray[begin] = firstHalf[i];
                    i++;
                }
                else{
                    mergedArray[begin] = secondHalf[j];
                    j++;
                }
                begin++;

                if((i==firstHalf.length) || (j==secondHalf.length) ){
                    break;
                }
            }

            if(i==firstHalf.length){
                while(j < secondHalf.length){
                    mergedArray[begin] = secondHalf[j];
                    j++;
                    begin++;
                }
            }
            else{
                while(i < firstHalf.length){
                    mergedArray[begin] = firstHalf[i];
                    i++;
                    begin++;
                }
            }

            return mergedArray;

        }else {
            int[] mergedArray = {arr[start]};
            return mergedArray;
        }

    }

    public static void main(String[] args) {

        int[] someArray = {7,1,6,4,2,5,7,2,3,5,2,3,6,6,5};

        int[] finalArr = mergeSort(someArray,0,someArray.length-1);
        System.out.println(finalArr);
    }
}
