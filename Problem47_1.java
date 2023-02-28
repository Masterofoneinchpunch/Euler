package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Distinct primes factors.
 * <p>
 * Faster solution than Problem47.java. 
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=47">Distinct primes factors</a>
 */
public final class Problem47_1 {
    private static final List<Long> primes = new ArrayList<Long>();
    
    public Problem47_1() {
    }

    //answer is 134043 (5 seconds)
    public static long problem47() {           
        final int inARowNum = 4;
        final int numOfFactors = 4;
        
        int inARowCount = 0;
        for (int i = 2; ; i++) {
            if ((MathUtil.isPrime(i))) {
                primes.add((long)i);
            }
            if (properDivisorsPrime(i) == numOfFactors) {
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
        Long prime = primes.get(0);
        
        for (int i = 1; prime <= number/2; i++) {
            if (number % prime == 0) {
                properDivisorsPrime++;
            }
            prime = primes.get(i);
        }
        
        return properDivisorsPrime;
    }
    
    public static void main(String[] args){
        System.out.println(problem47());
    }
}

