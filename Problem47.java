package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Distinct primes factors.
 * <p>
 * Slow solution.  I'm keeping for history sake.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=47">Distinct primes factors</a>
 */
public final class Problem47 {
    public Problem47() {
    }

    //answer is 134043 (46 seconds)
    public static long problem47() {           
        final int inARowNum = 4;
        final int numOfFactors = 4;
        
        int inARowCount = 0;
        for (int i = 647; ; i++) {
            final int propDivPrime = properDivisorsPrime(i);
            if (propDivPrime == numOfFactors) {
                ++inARowCount;
                if (inARowCount == inARowNum) {
                    return i - numOfFactors + 1;
                }
            } else {
                inARowCount = 0;
            }
        }
    }

    private static int properDivisorsPrime(final long number) {
        int properDivisorsPrime = 0;
        for (long i = number / 2; i > 1; i--) {
            if (number % i == 0 && MathUtil.isPrime(i)) {
                properDivisorsPrime++;
            }
        }
        
        return properDivisorsPrime;
    }
    
    public static void main(String[] args){
        System.out.println(problem47());
    }
}

