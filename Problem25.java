package com.mooip.code.projectEuler;

import java.math.BigInteger;

/**
 * 1000-digit Fibonacci number.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=25">1000-digit Fibonacci number</a>
 */
public final class Problem25 {
    public Problem25() {
    }

    //answer is 4782
    public static long problem25() {            
        BigInteger prev2Fib = new BigInteger("1");
        BigInteger prev1Fib = new BigInteger("1");
        for (int fibSequence = 3; ; fibSequence++) {
            BigInteger temp = prev1Fib.add(prev2Fib);
            
            prev2Fib = prev1Fib;        
            prev1Fib = temp;
            //System.out.println("sequence: " + fibSequence + " fib num: " + temp);
            
            if (temp.toString().length() >= 1000) {
                return fibSequence;
            }            
        }        
    }
    
    public static void main(String[] args){
        System.out.println(problem25());
    }    
}

