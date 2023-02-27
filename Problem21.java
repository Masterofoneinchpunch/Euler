package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Amicable numbers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=21">Amicable numbers</a>
 */
public final class Problem21 {
    public Problem21() {
    }

    //answer is 31626
    public static long problem21() {            
        long sum = 0;
        
        for (int i = 1; i <= 10000; ++i) {
            final int sumPropDiv = MathUtil.sumProperDivisors(i);
            final int othSumPropDiv = MathUtil.sumProperDivisors(sumPropDiv);
            
            if (i == othSumPropDiv & i != sumPropDiv) {
                System.out.println("amicable: " + i + " " + sumPropDiv + " " + othSumPropDiv);
                sum += i;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println(problem21());
    }    
}

