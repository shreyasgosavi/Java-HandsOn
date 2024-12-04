package com.problems;

import java.util.Scanner;

public class DiamondPattern {

    static int aASCII = 'A';
    static int inputCharacter;
    static int gap;
    static int spaceBetween = 0;
    static boolean isFinished = false;

    static boolean firstHalf = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        inputCharacter = sc.next().toUpperCase().charAt(0);
        gap = inputCharacter - aASCII;

        while (!isFinished) {

            for (int i = 0; i < gap; i++) {
                System.out.print(" ");
            }
            System.out.print((char) aASCII);

            if (aASCII != 'A') {
                for (int i = 0; i < spaceBetween; i++) {
                    System.out.print(" ");
                }
                System.out.print((char) aASCII);
            }
            for (int i = 0; i < gap; i++) {
                System.out.print(" ");
            }

            System.out.println();

            getUpdatedProperties();
        }




    }

    public static void getUpdatedProperties(){

        if(aASCII == inputCharacter){
            firstHalf = false;
        }

        if(aASCII == 'A' && !firstHalf){
            isFinished=true;
        }

        if(firstHalf){
            spaceBetween += 2;
            gap--;
            aASCII++;
        }
        else{
            aASCII--;
            spaceBetween -= 2;
            gap++;
        }

    }
}
