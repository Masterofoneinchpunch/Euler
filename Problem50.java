package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.List;

/**
 * Consecutive prime sum.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=50">Consecutive prime sum</a>
 */
public final class Problem50 {
    private static final int MAX_NUM = 999999;
    private static final List<Integer> primes = MathUtil.getPrimes(MAX_NUM);
    
    public Problem50() {
    }

    //answer is 997651
    public static long problem50() {   
        int maxConsecutiveCount = 0;
        int maxPrime = 0;
        final int maxConCount = 546; //the max consecutive count from 2 to over 999999
        int iCount = maxConCount;
        
        for (int i = 0; i <= iCount; i++) {
            int primeSum = 0;
            int consecutiveCount = 0;
            for (int j = i; j < maxConCount; j++) {
                final int prime = primes.get(j);
                primeSum += prime;
                if (primeSum > MAX_NUM) {
                    break;
                }

                if (primes.contains(primeSum)) {
                    consecutiveCount = j - i;
                    if (consecutiveCount > maxConsecutiveCount) {
                        maxConsecutiveCount = consecutiveCount;
                        maxPrime = primeSum;
                        iCount = maxConCount - maxConsecutiveCount;
                    }                    
                }
            }         
        }
        
        return maxPrime;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem50());      
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    } 
}

