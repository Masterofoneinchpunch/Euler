package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Prime power triples. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=87">Prime power triples</a>
 */
public final class Problem87 {
    private static final int LIMIT = 50000000; 
    private static final int MAX_PRIME_2ND_POW = 7072; //the second power would be less than 7072
    private static final int MAX_PRIME_3RD_POW = 369; //the third power would be less than 369
    private static final int MAX_PRIME_4TH_POW = 85; //the fourth power would be less than 85
    private static final List<Integer> primes2ndPow = MathUtil.getPrimes(MAX_PRIME_2ND_POW);
    private static final List<Integer> primes3rdPow = MathUtil.getPrimes(MAX_PRIME_3RD_POW);
    private static final List<Integer> primes4thPow = MathUtil.getPrimes(MAX_PRIME_4TH_POW);
    private static final Set numBelowLimitTotalDistinct = new HashSet();

    public Problem87() {
    }

    //answer is 
    public static long Problem87() {             
        for (Integer prime2ndPow : primes2ndPow) {
            final int pow2nd = prime2ndPow * prime2ndPow;
            for (Integer prime3rdPow : primes3rdPow) {
                final int pow3rd = (int) Math.pow(prime3rdPow, 3);
                for (Integer prime4thPow: primes4thPow) {
                    final int pow4th = (int) Math.pow(prime4thPow, 4);
                    final int total = pow2nd + pow3rd + pow4th;
                    if (total >= LIMIT) {
                        break;
                    }
                    numBelowLimitTotalDistinct.add(total);
                }
            }
        }
        
        return numBelowLimitTotalDistinct.size();
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(Problem87());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }   
}

