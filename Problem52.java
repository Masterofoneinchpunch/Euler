package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Permuted multiples.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=52">Permuted multiples</a>
 */
public final class Problem52 {
    public Problem52() {
    }

    //answer is 142857
    public static long problem52() {          
        outer:
        for (int i = 6; i < 1000000; i++) {
            final int multi = i * 2;
            for (int j = 3; j <= 6; j++) {
                if (MathUtil.sameDigits(multi, (i * j)) == false) {
                    continue outer;
                }                
            }
            return i;
        }
        
        return -1;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem52());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}


