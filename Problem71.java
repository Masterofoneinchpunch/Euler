package com.mooip.code.projectEuler;

import java.math.BigDecimal;
import java.math.RoundingMode;
        
/**
 * Ordered fractions.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=71">Ordered fractions</a>
 */
public final class Problem71 {
    public Problem71() {
    }

    //https://projecteuler.net/problem=71
    //answer is 428570
    public static int problem71() {   
        BigDecimal largestSmaller = new BigDecimal(.4); // 2/5
        Integer largestSmallerNum = null, largestSmallerDenom = null;
        BigDecimal larger3_7 = divide(428571,999999); //this is the same as 3/7
        
        int newDenom = 999999;
        for (int num = 428570; num > 428500; num--) {
            for (int denom = newDenom;; denom--) {
                BigDecimal bd = divide(num, denom);
                System.out.print("divide(" + num + "," + denom + "): " + bd);
                //once you go past 3/7 with the denom it will only get larger so break and set the new
                //denom to use.
                if (bd.compareTo(larger3_7) >= 1 || bd.compareTo(larger3_7) == 0) {
                    if (bd.compareTo(larger3_7) == 0) {
                        System.out.println(" same 3/7");
                    } else {
                        System.out.println(" goes over");
                    }
                    newDenom = denom;
                    break;
                }
                if (bd.compareTo(largestSmaller) >= 1 && bd.compareTo(larger3_7) <= -1) {
                    System.out.println(" winner");
                    largestSmaller = bd;
                    largestSmallerNum = num;
                    largestSmallerDenom = denom; //not used, but I'm keeping track.
                } else {
                    System.out.println("");
                }               
            }
        }
                
        return largestSmallerNum;
    }
   
    private static BigDecimal divide(int numerator, int denominator) {
        BigDecimal num = new BigDecimal(numerator);
        BigDecimal denom = new BigDecimal(denominator);
        
        return num.divide(denom, 30, RoundingMode.HALF_UP);
    }  

    public static void main(String[] args){        
        System.out.println(problem71());
    }

}

