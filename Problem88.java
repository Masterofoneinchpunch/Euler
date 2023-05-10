package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Product-sum numbers. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=88">Product-sum numbers</a>
 * @see <a href="https://github.com/nayuki/Project-Euler-solutions/blob/master/java/p088.java">Big Help</a>
 */
public final class Problem88 {
    private static final int LIMIT = 12000;
    
    private static int[] minProductSum;
    private static final Set<Integer> uniqueSums = new HashSet<Integer>();
    
    public Problem88() {
    }

    //answer is 7587457
    /*
    I noticed this: 
    
    5: 5 * 2 * 1 * 1 * 1 = 5 + 2 + 1 + 1 + 1 (10) (but not minimum)
    6: 6 * 2 * 1 * 1 * 1 * 1 = 6 + 2 + 1 + 1 + 1 + 1 (12) (and minimum)
    7: 7 * 2 * 1 * 1 * 1 * 1 * 1 = 7 + 2 + 1 + 1 + 1 + 1 + 1 (14) (but not minimum)
    
    Trying to find an identifiable pattern for the minimum gets you into a whole lot of trouble.  You will
    find patterns up until a certain point and then it will vanish. One aspect that threw me off was
    that you can go down in N as k goes up (rare but it happens, 
    for example k = 23 with N = 30; k = 22 with N = 32)
   
    */
    public static long problem88() {   
        minProductSum = new int[LIMIT + 1];
	Arrays.fill(minProductSum, Integer.MAX_VALUE);    
        minProductSum[0] = 0;
        minProductSum[1] = 0;
        for (int N = 4; N < LIMIT * 1.25; N++) {
            factorize(N,N,N,0,0);
        }
        //System.out.println(Arrays.toString(minProductSum));
        
        return MathUtil.setSum(uniqueSums);
    }

    /* 
        N is the natural number. 1 term solutions are ignored by the criteria of the problem
        by checking minProductSum[1].
    
	 * Calculates all factorizations of N >= 4 and updates smaller solutions into minProductSum.
	 * Here is an example for N = 12 with the logging:
            N: 12 remain: 12 maxFactor: 12 partialSum: 0 terms: 0
            N: 12 remain: 6 maxFactor: 2 partialSum: 2 terms: 1
            N: 12 remain: 3 maxFactor: 2 partialSum: 4 terms: 2
            N: 12 remain: 4 maxFactor: 3 partialSum: 3 terms: 1
            N: 12 remain: 2 maxFactor: 2 partialSum: 5 terms: 2
            N: 12 remain: 1 maxFactor: 2 partialSum: 7 terms: 3
            added for k: 8 -- this is 3 * 2 * 2 * 1 * 1 * 1 * 1 * 1
            amount of 1s: 5
            N: 12 remain: 3 maxFactor: 4 partialSum: 4 terms: 1
            N: 12 remain: 1 maxFactor: 3 partialSum: 7 terms: 2
            added for k: 7 -- this is 4 * 3 * 1 * 1 * 1 * 1 * 1
            amount of 1s: 5
            N: 12 remain: 2 maxFactor: 6 partialSum: 6 terms: 1
            N: 12 remain: 1 maxFactor: 2 partialSum: 8 terms: 2
            added for k: 6 -- this is 6 * 2 * 1 * 1 * 1 * 1
            amount of 1s: 4
            N: 12 remain: 1 maxFactor: 12 partialSum: 12 terms: 1 //this is the 
    */
    private static void factorize(final int N, final int remain, final int maxFactor, final int partialSum, int terms) {
        //System.out.println("N: " + N + " remain: " + remain + " maxFactor: " + maxFactor + " partialSum: " + partialSum + " terms: " + terms);
        if (remain == 1) {
            terms += N - partialSum; //N - partialSum is the count of the 1s; terms becomes k value
            
            if (terms <= LIMIT && N < minProductSum[terms]) {
                //System.out.println("added for k: " + terms);
                //System.out.println("amount of 1s: " + (N - partialSum));
                minProductSum[terms] = N;
                uniqueSums.add(N); //might need to remove this here
            } 
        } else {
            //first divide by 2, then increment making sure it divides evenly; you will also get k values out-of-order sometimes.
            for (int factor = 2; factor <= maxFactor; factor++) {
                if (remain % factor == 0) {
                    //factorize(N, remain / factor, Math.min(factor, maxFactor), partialSum + factor, terms + 1);
                    factorize(N, remain / factor, factor, partialSum + factor, terms + 1);
                }
            }
        }
    }    
    
    public static void main(String[] args){
        System.out.println(problem88());
    }   
}

