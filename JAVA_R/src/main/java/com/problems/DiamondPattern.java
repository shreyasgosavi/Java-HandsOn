package com.problems;

import java.util.ArrayList;

import java.util.List;

class DiamondPattern {

    static int aASCII = 'A';
    static int inputCharacter;
    static int gap;
    static int spaceBetween = 0;
    static boolean isFinished = false;
    static boolean firstHalf = true;
    List<String> printToList(char a) {


        inputCharacter = a;
        gap = inputCharacter - aASCII;
        ArrayList<String> rowLines = new ArrayList<>();

        while (!isFinished) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < gap; i++) {
                System.out.print(" ");
                sb.append(" ");
            }
            System.out.print((char) aASCII);
            sb.append((char) aASCII);

            if (aASCII != 'A') {
                for (int i = 0; i < spaceBetween; i++) {
                    System.out.print(" ");
                    sb.append(" ");
                }
                System.out.print((char) aASCII);
                sb.append((char) aASCII);
            }
            for (int i = 0; i < gap; i++) {
                System.out.print(" ");
                sb.append(" ");
            }

            System.out.println();
            rowLines.add(sb.toString());
            getUpdatedProperties();
        }
        return rowLines;
    }

    public static void getUpdatedProperties() {

        if (aASCII == inputCharacter) {
            firstHalf = false;
        }

        if (aASCII == 'A' && !firstHalf) {
            isFinished = true;
        }

        if (firstHalf) {
            spaceBetween += 2;
            gap--;
            aASCII++;
        } else {
            aASCII--;
            spaceBetween -= 2;
            gap++;
        }

    }

    public static void main(String[] args) {

        DiamondPattern diamondPattern = new DiamondPattern();
        List<String> string = diamondPattern.printToList('D');

        System.out.println(string);
    }
}


//public class DiamondPattern {
//
//    static int aASCII = 'A';
//    static int inputCharacter;
//    static int gap;
//    static int spaceBetween = 0;
//    static boolean isFinished = false;
//
//    static boolean firstHalf = true;
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        inputCharacter = sc.next().toUpperCase().charAt(0);
//        gap = inputCharacter - aASCII;
//
//        while (!isFinished) {
//
//            for (int i = 0; i < gap; i++) {
//                System.out.print(" ");
//            }
//            System.out.print((char) aASCII);
//
//            if (aASCII != 'A') {
//                for (int i = 0; i < spaceBetween; i++) {
//                    System.out.print(" ");
//                }
//                System.out.print((char) aASCII);
//            }
//            for (int i = 0; i < gap; i++) {
//                System.out.print(" ");
//            }
//
//            System.out.println();
//
//            getUpdatedProperties();
//        }
//
//
//    }
//
//    public static void getUpdatedProperties() {
//
//        if (aASCII == inputCharacter) {
//            firstHalf = false;
//        }
//
//        if (aASCII == 'A' && !firstHalf) {
//            isFinished = true;
//        }
//
//        if (firstHalf) {
//            spaceBetween += 2;
//            gap--;
//            aASCII++;
//        } else {
//            aASCII--;
//            spaceBetween -= 2;
//            gap++;
//        }
//
//    }
//}
