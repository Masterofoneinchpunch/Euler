package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Quadratic primes.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=27">Quadratic primes</a>
 */
public final class Problem27 {
    public Problem27() {
    }

    //https://projecteuler.net/problem=27
    //answer is -59231
    public static long problem27() {     
        int maxConPrimes = 0;
        int maxConA = -1;
        int maxConB = -1;
        
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int conPrimes = numConPrimes(a, b);
                if (maxConPrimes < conPrimes) {
                    maxConPrimes = conPrimes;
                    maxConA = a;
                    maxConB = b;
                    System.out.println("maxConPrimes: " + maxConPrimes + " " + maxConA + " " + maxConB);
                }                                
            }
        }
        
        System.out.println("last maxConPrimes: " + maxConPrimes + " " + maxConA + " " + maxConB);
        
        return maxConA * maxConB;
    }

    private static int numConPrimes(int a, int b) {
        for (int n = 0; ; n++) {
            int sum = ((n * n) + (a * n) + b);
            if (MathUtil.isPrime(sum) == false) {
                return n;
            }
        }
    }
    
    public static void main(String[] args){
        System.out.println(problem27());
    }  
}
