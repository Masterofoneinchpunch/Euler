package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.Set;

/**
 * Prime digit replacements.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=51">Prime digit replacements</a>
 */
public final class Problem51 {
    private static final int MIN_NUM = 1; 
    private static final int MAX_NUM = 1000000;
    private static final int MAX_IN_PRIME_TEN = 8;
    private static final Set<Integer> primesMin = MathUtil.getPrimes(MIN_NUM, MAX_NUM);
    
    public Problem51() {
    }

    //first seven value is 56003, for 100000 over it is 7 for: 101917
    //answer is 121313
    public static int problem51() {   
        int maxPrimeCount = 0;
        for (Integer prime : primesMin) {
            String primeStr = String.valueOf(prime);
            
            //skip the last digit because that will never be part of the answer (even numbers)
            for (int i = 2; i <= primeStr.length(); i++) {
                final int digit = MathUtil.getNthDigit(prime, i);  
                final int add = (int) Math.pow(10, i - 1);
                if (digit < 3) { //if the value is 3 or over it will never get past 7
                    //if you only change one digit you can never get to 8 (because of divide by 3)
                    int primeCount = 0; //getPrimeCount(prime, digit, add);
                    //if (primeCount > maxPrimeCount) {
                    //    maxPrimeCount = primeCount;
                    //}
                    //going over two digits
                    for (int j = i+1; j <= primeStr.length(); j++) {
                        final int digit2 = MathUtil.getNthDigit(prime, j); 
                        if (digit2 != digit) {
                            continue;
                        }
                        final int add2 = (int) Math.pow(10, j - 1);
                        primeCount = getPrimeCount(prime, digit2, (add + add2));
                        if (primeCount > maxPrimeCount) {
                            maxPrimeCount = primeCount;
                        }
                        
                        //going over three digits
                        for (int k = j+1; k <= primeStr.length(); k++) {
                            final int digit3 = MathUtil.getNthDigit(prime, k);
                            if (digit3 != digit2) {
                                continue;
                            }
                            final int add3 = (int) Math.pow(10, k - 1);
                            primeCount = getPrimeCount(prime, digit3, (add + add2 + add3));
                            if (primeCount > maxPrimeCount) {
                                maxPrimeCount = primeCount;
                            }
                        }
                        
                        if (maxPrimeCount >= MAX_IN_PRIME_TEN) {
                            return prime;
                        }
                    }
                }
            }
        }
        //System.out.println("Max Prime Count: " + maxPrimeCount + " for: " + firstPrimeValueWithMax);                       
        
        return -1;
    }

    private static int getPrimeCount(int prime, int digit, int add) {
        int primeCount = 1; //the number we start off with is a prime.
        int nextPrime = prime;
        int miss = digit;
        for (int j = digit; j < 9; j++) {
            nextPrime += add;

            if (primesMin.contains(nextPrime)) {
                primeCount++;
            } else {
                miss++;
            }
            if (miss > 2) {
                break;
            }
        }
        return primeCount;
    }
    
    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem51());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}