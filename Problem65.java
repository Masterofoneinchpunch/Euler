package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Convergents of e.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=65">Convergents of e</a>
 */
public final class Problem65 {
    public Problem65() {
    }

    //https://projecteuler.net/problem=65
    //answer is 272
    public static long problem65() {
        int thirdRepeatFracRep = 2;
        
        BigInteger prevNumerator = new BigInteger("3");
        BigInteger prevDenominator = new BigInteger("1");
        BigInteger numerator = new BigInteger("8");
        BigInteger denominator = new BigInteger("3");
        //continued fraction representations
        for (int i = 1; i <= 100 - 3; i++) {
            BigInteger tempNumerator = numerator;
            BigInteger tempDenominator = denominator;
            
            if (i % 3 == 0) {
                thirdRepeatFracRep += 2;
                numerator = numerator.multiply(new BigInteger(String.valueOf(thirdRepeatFracRep)));
                denominator = denominator.multiply(new BigInteger(String.valueOf(thirdRepeatFracRep)));
            }
            
            numerator = numerator.add(prevNumerator);
            denominator = denominator.add(prevDenominator);

            prevNumerator = tempNumerator;
            prevDenominator = tempDenominator;
        }
        
        return MathUtil.addStringDigits(numerator.toString());
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem65());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    } 
}


