package com.problems;

import java.util.Scanner;

public class DiamondPattern {

    public static void main(String[] args) {

        int aASCII = 'A';
        Scanner sc = new Scanner(System.in);
        int inputCharacter = sc.next().toUpperCase().charAt(0);

        int gap = inputCharacter - aASCII;
        int spaceBetween = 0;

        boolean isFinished = false;
        while (aASCII < inputCharacter+1) {

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

            if(aASCII < inputCharacter) {
                spaceBetween += 2;
                gap--;
            }
            else {
                aASCII--;
                spaceBetween -= 2;
                gap++;
                break;
            }
            aASCII++;
        }

        while(aASCII >='A'){

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
            aASCII--;
            spaceBetween -= 2;
            gap++;

        }


    }
}
