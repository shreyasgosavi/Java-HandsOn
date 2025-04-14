package com.streams;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InputStreamHa {

    public static void main(String[] args) throws IOException{

        String aString = "This is a string.";
        CustomInputStream is = new CustomInputStream(aString);

        int c = is.read();
        while( c != -1){
            System.out.print((char) c);
            c = is.read();
        }
    }
}


class CustomInputStream extends InputStream{

    private final String data;
    private int position = 0;

    CustomInputStream(String data){
        this.data = data;
    }

    @Override
    public int read() throws IOException{

        if(position < data.length()){
            return data.charAt(position++);
        }

        return -1;
    }

}