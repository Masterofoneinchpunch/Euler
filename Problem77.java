package com.mooip.code.projectEuler;

import com.mooip.code.recursive.SubsetSum;
import com.mooip.util.ListUtil;
import com.mooip.util.MathUtil;
import java.util.List;

/**
 * Prime summations.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=77">Prime summations</a>
 */
public final class Problem77 {
    public Problem77() {
    }

    //answer is 71
    public static long problem77() {   
        for (int i = 11; ; i++) {
            final List<Integer> primes = MathUtil.getPrimes(i);           
            final int sumOfPrimes = SubsetSum.subsetsNonRecursion(ListUtil.toArray(primes), i);
            
            if (sumOfPrimes > 5000) {
                return i;
            }
        }
    }
    
    public static void main(String[] args){
        System.out.println(problem77());
    }  
}


