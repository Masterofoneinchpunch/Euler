package com.mooip.code.projectEuler;

import com.mooip.code.recursive.PermutationNumberPrimes;
import com.mooip.util.MathUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Prime permutations.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=49">Prime permutations</a>
 */
public final class Problem49 {
    private static final List<Integer> primes = new ArrayList<Integer>();
    
    public Problem49() {
    }

    //answer is 296962999629
    public static long problem49() {
        for (int i = 1001; i <= 9999; i += 2) {
            if ((MathUtil.isPrime(i))) {
                primes.add(i);
            }
        }
        
        for (int i = 0; i < primes.size(); i++) {
            final Integer permNum = primes.get(i);
            Set<Integer> permNums = PermutationNumberPrimes.getLargerPermutationNumbers(permNum);
            if (permNums.size() < 2) {
                continue;
            }
            
            for (Integer nextPermNum : permNums) {
                final int diff = nextPermNum - permNum;
                if (permNums.contains(nextPermNum + diff)) {
                    System.out.println("we have a winner with: " + permNum + nextPermNum + (nextPermNum + diff));
                }
            }
        }
                
        return -1; //this will return a -1 because the above println shows two solutions, pick the last.
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem49());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }
}

