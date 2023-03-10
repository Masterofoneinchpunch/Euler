package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Square root digital expansion. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=80">Square root digital expansion</a>
 * @see <a href="https://en.wikipedia.org/wiki/Methods_of_computing_square_roots">Methods_of_computing_square_roots</a>
 */
public final class Problem80 {
    public Problem80() {
    }

    //answer is 40886
    public static long problem80() {          
        int totalSum = 0;
        for (int i = 1; i <= 100; i++) {
            int sqrInt = (int) Math.sqrt(i);
            if (sqrInt * sqrInt == i) {
                continue;
            }
            BigInteger bi = MathUtil.squareRootDigits(i, 100);
            totalSum += MathUtil.addStringDigits(bi.toString());
        }
        
        return totalSum;
    }
    
    public static void main(String[] args){
        System.out.println(problem80());
    }   
}

