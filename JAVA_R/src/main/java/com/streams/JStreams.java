package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JStreams {


    public static void main(String[] args) {
        int[] sampleArray = {2,3,4,5};
        Arrays.stream(sampleArray).filter((a) -> a > 4);

        List<Integer> intList = new ArrayList<>(Arrays.asList(3,4,5,6));
        List<Integer> filtered = intList.stream().filter(i -> i>5).toList();

        filtered.stream().map(i -> i * 2).collect(Collectors.toList());

        Stream.of(3,4,5,6);

        System.out.println(Stream.iterate(0, i -> i+2).limit(43).toList());
    }
}
