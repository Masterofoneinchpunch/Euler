package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Counting fractions.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=72">Counting fractions</a>
 */
public final class Problem72 {
    public Problem72() {
    }

    //answer is 303963552391
    public static long problem72() {   
        long runningCount = 0;
        for (int i = 2; i <= 1000000; i++) {
            final int relativePrimeCount = MathUtil.getRelativePrimesCount(i);
            runningCount += relativePrimeCount;
        }
        
        return runningCount;
    }

    public static void main(String[] args){
        System.out.println(problem72());
    }  
}


