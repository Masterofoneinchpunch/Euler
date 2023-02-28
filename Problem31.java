package com.mooip.code.projectEuler;

import com.mooip.code.recursive.SubsetSum;

/**
 * Coin sums.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=31">Coin sums</a>
 */
public final class Problem31 {
    public Problem31() {
    }

    //https://projecteuler.net/problem=31
    //answer is 73682
    public static int problem31() {   
        final int total = 200;        
        final int[] coins = {1,2,5,10,20,50,100,200};
        
        return SubsetSum.subsetsRecursion(coins, coins.length, total);
    }
    
    public static void main(String[] args){
        System.out.println(problem31());
    }
}
