package com.mooip.code.projectEuler;

/**
 * Smallest multiple. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=5">Smallest multiple</a>
 */
public final class Problem5 {

    public Problem5() {
    }

    //answer is 232792560
    public static long problem5() {
        top:
        for (long i = 2520; i < Long.MAX_VALUE; i += 20) {
            for (int j = 11; j <= 20; ++j) {
                if (i % j != 0) {
                    continue top;
                }
            }
            return i;
        }
        
        return -1L;
    }
    
    public static void main(String[] args){
        System.out.println(problem5());
    }
    
}


