package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Combinatoric selections.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=53">Combinatoric selections</a>
 */
public final class Problem53 {
    public Problem53() {
    }

    //answer is 4075
    public static int problem53() {
        int comboOverMillion = 0;
        
        outer:
        for (int n = 23; n <= 100; n++) {
            for (int r = 1; r < n; r++) {
                final BigInteger bi = MathUtil.combinatoric(n, r);
                
                if (bi.longValue() > 1000000) {
                    comboOverMillion += (n - (r * 2) + 1);
                    continue outer;
                }
                
            }
        }
        
        return comboOverMillion;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem53());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    } 
}

