package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JavaEight {

    public static void main(String[] args) {

        String a = "SHR";
        String b = "Shub";
        String c = "NMNK";

        List<String> someString = Arrays.asList(a, b, c);

        someString.set(1,"VIR");

        someString.sort(null);
        System.out.println(someString);

    }
}
