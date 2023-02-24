package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Highly divisible triangular number.
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=12">Highly divisible triangular number</a>
 */
public final class Problem12 {
    public Problem12() {
    }

    //answer is 76576500 (divisor count: 576) 
    public static long problem12(int divisorCount) {
        long triangleNumber = 0;
        int numDivisors = 0;
        
        for (int i = 1; numDivisors < divisorCount; i++) {
            triangleNumber += i;
                        
            if (triangleNumber % 10 == 0) {
                numDivisors = MathUtil.numOfDivisors(triangleNumber);
            }
        }
              
        return triangleNumber;
    }
        
    public static void main(String[] args){       
        System.out.println(problem12(500));
    }   
}
