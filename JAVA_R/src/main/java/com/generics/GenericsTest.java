package com.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenericsTest {

    GenericsTest(){

    }
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap();
        hm.put("haha","SDs");

        for(Map.Entry e  :hm.entrySet()){
            System.out.println(e.getKey() +"  "+e.getValue());
        }
    }
}

class Box<A,V> implements ObjectType{
    A someObject;

    public A getObject(){
        return someObject;
    }
}

interface ObjectType<T>{
    public T getObject();
}
