package com.mooip.code.projectEuler;

import com.mooip.code.recursive.SubsetSum;

/**
 * Counting summations.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=76">Counting summations</a>
 */
public final class Problem76 {
    public Problem76() {
    }

    //answer is 190569291
    public static long problem76() {   
        final int subsetSum = 100;
        
        int[] subsets = new int[subsetSum - 1];     
        for (int i = 0; i < subsets.length; i++) {
            subsets[i] = i+1;
        }

        return SubsetSum.subsetsNonRecursion(subsets, subsetSum);
    }

    public static void main(String[] args){
        System.out.println(problem76());
    } 
}

