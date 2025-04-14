package com.streams;

import java.io.IOException;
import java.io.PrintStream;

public class OutputToSomeSource {

    public static void main(String[] args) {

        PrintStream ps = new PrintStream(System.out);
        String s = "This is some value";

        try {
            ps.write(s.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
