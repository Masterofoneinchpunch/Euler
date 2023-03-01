package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import com.mooip.util.StringUtil;

/**
 * Totient permutation.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=70">Totient permutation</a>
 */
public final class Problem70 {
    public Problem70() {
    }

    //answer is 8319823
    public static int problem70() {   
        double minTotientDiv = 10;
        int totientMinNum = 0;
        
        //currently 12 seconds
        for (int i = 3; i < 10000000; i = i + 2) {
            if (i % 3 == 0) {
                continue;
            }
            final int relPrimeCount = MathUtil.getRelativePrimesCount(i);
            final double totientDiv = (double) i/relPrimeCount;
            
            if (StringUtil.isPermutation(String.valueOf(i), String.valueOf(relPrimeCount))) {
                if (minTotientDiv > totientDiv) {
                    minTotientDiv = totientDiv;
                    totientMinNum = i;
                }
            }
        }

        return totientMinNum;
    }

    public static void main(String[] args){
        System.out.println(problem70());
    } 
}

