package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Goldbach's other conjecture.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=46">Goldbach's other conjecture</a>
 */
public final class Problem46 {
    private static final List<Long> primes = new ArrayList<Long>();
    
    public Problem46() {
    }

    //answer is 5777
    public static long problem46() {           
        primes.add(3L);
        primes.add(5L);
        primes.add(7L);
        
        outer: 
        for (long i = 9; i < 10000; i += 2) {
            if (MathUtil.isPrime(i)) {
                primes.add(i);
                continue;
            }
            for (Long prime : primes) {
                long sum = prime;
                for (int j = 1; i > sum; j++) {
                    final int sqTimes2 = j * j * 2;
                    sum = prime + sqTimes2;
                    if (sum == i) {
                        continue outer;
                    }
                }
            }
            return i;
        }
        
        return -1;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem46());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    } 
}

