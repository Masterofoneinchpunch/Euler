package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Powerful digit sum.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=56">Powerful digit sum</a>
 */
public final class Problem56 {
    public Problem56() {
    }

    //answer is 972
    public static int problem56() {
        int maxSum = 0;
        
        for (int i = 5; i < 100; i++) {
            final BigInteger num = new BigInteger(String.valueOf(i));
            for (int j = 10; j < 100; j++) {
                final int addSum = (int) MathUtil.addStringDigits(num.pow(j).toString());
                
                if (maxSum < addSum) {
                    maxSum = addSum;
                }
            }
        }
        
        return maxSum;
    }

    public static void main(String[] args){
        System.out.println(problem56());
    }  
}

