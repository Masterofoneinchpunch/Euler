package com.mooip.code.projectEuler;

import java.math.BigInteger;

/**
 * Square root convergents.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=57">Square root convergents</a>
 */
public final class Problem57 {
    public Problem57() {
    }

    //https://projecteuler.net/problem=57
    //answer is 153
    public static int problem57() {   
        int moreDigitsDenominator = 0;
        
        BigInteger numerator = new BigInteger("3");
        BigInteger denominator = new BigInteger("2");
        for (int i = 2; i <= 1000; i++) {
            BigInteger oldDenominator = denominator;
            denominator = denominator.add(numerator);            
            numerator = denominator.add(oldDenominator);
            System.out.println("num: " + numerator + "denom: " + denominator);
            if (String.valueOf(numerator).length() > String.valueOf(denominator).length()) {
                moreDigitsDenominator++;
            }
        }
        
        return moreDigitsDenominator;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem57());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }
}

