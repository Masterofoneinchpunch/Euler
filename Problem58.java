package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Spiral primes.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=58">Spiral primes</a>
 */
public final class Problem58 {
    public Problem58() {
    }

    //answer is 26241
    public static int problem58() {   
        return spiralSearching(30001);
    }

    private static int spiralSearching(final int level) {
        if (level % 2 == 0) {
            throw new IllegalArgumentException("The level has to be odd.");
        }
        int levelIncrement = 2;
        int revolveEdgeNum = 1;
        int totalPrime = 0;
        int totalEdges = 1;
        
        for (int i = 3; i <= level; i += 2) {
            for (int add = 1; add <= 4; add++) {
                revolveEdgeNum += levelIncrement;
                ++totalEdges;
                if (MathUtil.isPrime(revolveEdgeNum)) {
                    totalPrime++;
                }
            } 
            levelIncrement += 2; //every swirl this adds two
            
            final double primePercentage = (double) totalPrime / totalEdges;            
            if (primePercentage < .10) {
                System.out.println("totalPrime: " + totalPrime + " " + totalEdges + " " + primePercentage);
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args){
        System.out.println(problem58());
    }  
}
