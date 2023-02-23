package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * 10001st prime. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=7">10001st prime</a>
 */
public class Problem7 {

    public Problem7() {
    }

    //answer is 104743
    public static long generatePrime(int numOfPrimes) {
        int primeNumber = 2;
        int primeCount = 1;
        if (numOfPrimes == 1) {
            return primeNumber;
        }
        int nextCandidatePrime = primeNumber + 1;
        
        while (primeCount < numOfPrimes) {
            if (MathUtil.isPrime(nextCandidatePrime)) {
                primeCount++;
                primeNumber = nextCandidatePrime;
            }
            
            nextCandidatePrime += 2;
        }
        
        return primeNumber;
    }
    
    public static void main(String[] args){
        System.out.println(generatePrime(10001));
    }
    
}


