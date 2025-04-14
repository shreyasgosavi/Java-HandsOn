package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LetsBegin {

    public static void main(String[] args) {

        int[] integerArray = new int[4];
//        System.out.println(integerArray[5]);

        Object[] someObj = new Object[10];
        someObj[0] = "asc";
        someObj[1] = "asc";
        someObj[2] = "asc";
        someObj[3] = "asc";
        someObj[4] = "asc";
        someObj[5] = "asc";



        Object[] someObj2 = new Object[10];
        someObj2[0] = "asc";
        someObj2[1] = "asc";
        someObj2[2] = "asc";
        someObj2[3] = "asc";
        someObj2[4] = "asc";
        someObj2[5] = "asc";

        List<Object[]> list = new ArrayList<>();

        list.add(someObj);
        list.add(someObj2);

//        System.out.println(list.get(3));

//        list.add(3);
//        list.add(6);
//        list.add(6);
//        list.add(6);
//        list.add(4,2);

        System.out.println(list);
        List<Integer> integerList = new ArrayList<>(100);
        System.out.println("Size of list is :: "+integerList.size());

        List<Integer> listArr =  Arrays.asList(3,4,5);
        listArr.add(6);

        List.of(3,4,5,6,67,4,4,3,4,5,6);



    }
}
