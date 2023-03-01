package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Totient maximum.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=69">Totient maximum</a>
 */
public final class Problem69 {
    public Problem69() {
    }

    //https://projecteuler.net/problem=69
    //answer is 510510
    public static int problem69() {        
        double maxTotientDiv = 0;
        int totientMaxNum = 0;
        for (int i = 2; i <= 1000000; i = i + 2) {
            if (i % 3 != 0) {
                continue;
            }
            final int relPrimeCount = MathUtil.getRelativePrimesCount(i);
            final double totientDiv = (double) i/relPrimeCount;
            
            if (maxTotientDiv < totientDiv) {
                maxTotientDiv = totientDiv;
                totientMaxNum = i;
                System.out.print("max: " + maxTotientDiv);
                System.out.println(" for: " + i);
            }
        }
        
        return totientMaxNum;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem69());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }   
}


