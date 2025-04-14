package com.streams;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderHa {

    public static void main(String[] args) {

        String s = "Hahaha";

        StringReader sr = new StringReader(s);
        int i;

        try {
             do{
                 i = sr.read();
                System.out.println((char) i);
            }while (sr.read() != -1);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }
}
