package com.leetCode;

import java.math.BigDecimal;
import java.math.BigDecimal;

public class StringMultiply {

    public static String multiply(String num1, String num2) {
        
        BigDecimal result = new BigDecimal("0");

        if( num1=="0" || num2 == "0" ){
            return "0";
        }


        int stepsNum = 0;
        for(int i=num1.length()-1; i>=0; i--){

            BigDecimal temp= new BigDecimal("0");
            long multiplier = (long)num1.charAt(i) - 48;

            if(multiplier != 0){

                long carryForwarded=0;
                int steps=0;
                for(int j = num2.length()-1; j>=0;j--){

                    int multiplicand = (int)num2.charAt(j) - 48;
                    long cross = multiplier*multiplicand;
                    long add = (cross%10)+carryForwarded;

                    temp = temp.add((j==num2.length()-1)?new BigDecimal(add+""):new BigDecimal(add*(long)Math.pow(10,steps)+""));
//                    temp += (j==num2.length()-1)?add:add*Math.pow(10,steps);

                    if(cross >=10){
                        carryForwarded = cross/10;
                    }
                    else{
                        carryForwarded =0;
                    }
                    steps++;
                }
                if(carryForwarded > 0){
                    temp = temp.add(new BigDecimal(carryForwarded*(long)Math.pow(10,num2.length())+""));
                }
            }

            BigDecimal addVAl = (i==num1.length()-1)?temp:temp.multiply(new BigDecimal((long)Math.pow(10, stepsNum)+""));
            stepsNum++;
            result = result.add(addVAl);
//            System.out.println("Result is "+result);

        }

        return ""+result;

    }

    public static void main(String[] args) {

        System.out.println(multiply("925101087184894","3896737933784656127"));
//
//        BigDecimal s1 = new BigDecimal("498828660196");
//        BigDecimal s2 = new BigDecimal("498828660196");



//        String s2 = "840477629533";

//        System.out.println(multiply(s1,s2));
//        long a = 121932631112635269l;

//        System.out.println(a);

    }
}
