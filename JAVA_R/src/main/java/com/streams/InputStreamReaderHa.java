package com.streams;

import java.io.*;

public class InputStreamReaderHa {

    public static void main(String[] args) throws Exception {

        FileInputStream is = new FileInputStream("C:\\Users\\shreyasgosavi\\Desktop\\linux_commands_detailed.txt");

//        int a = is.read();
//        while(a!=-1){
//            a=is.read();
//        }

        for(byte b : is.readAllBytes()){
            System.out.println(b);
        }

//        try(InputStreamReader isr = new InputStreamReader(System.in)) {
//
//            int i = isr.read();
//            while(isr.ready()){
//                System.out.println((char)i);
//                i = isr.read();
//            }
//
//        }catch(IOException ioException){
//            System.out.println(ioException.getMessage());
//        }

    }

}
