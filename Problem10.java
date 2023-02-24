package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Summation of primes. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=10">Summation of primes</a>
 */
public final class Problem10 {
    public Problem10() {
    }

    //answer is 142913828922
    public static long generateSumOfPrimes(int maxPrime) {
        long primesSum = 2;
        int nextCandidatePrime = 3;
        
        while (nextCandidatePrime < maxPrime) {
            if (MathUtil.isPrime(nextCandidatePrime)) {
                primesSum += nextCandidatePrime;
            }
            
            nextCandidatePrime += 2;
        }
        
        return primesSum;
    }
    
    public static void main(String[] args){
        System.out.println(generateSumOfPrimes(2000000));
    }  
}


