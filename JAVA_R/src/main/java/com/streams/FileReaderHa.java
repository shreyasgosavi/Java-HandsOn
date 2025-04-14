package com.streams;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderHa {

    public static void main(String[] args) {

        try(FileReader fr = new FileReader("someText.txt")){
            while(fr.ready()){
                System.out.println(fr.read());
            }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }

    }
}
