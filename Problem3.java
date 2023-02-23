package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Largest prime factor. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=3">Largest prime factor</a>
 */
public final class Problem3 {
    public Problem3() {
    }

    //answer is 6857
    public static long problem3() {
        final long number = 600851475143L; 
        for (int i = (int) Math.sqrt(number); i > 2; i--) {
            if (MathUtil.isPrime(i) && number % i == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        System.out.println(problem3());
    }    
}

