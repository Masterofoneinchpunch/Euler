package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;
import java.math.BigInteger;

/**
 * Lychrel numbers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=55">Lychrel numbers</a>
 */
public final class Problem55 {
    public Problem55() {
    }

    //answer is 249
    public static int problem55() {
        int lychrelCount = 0;
        
        outer:
        for (int i = 1 ; i < 10000; i++) {
            BigInteger bi = new BigInteger(String.valueOf(i));
            
            for (int j = 1; j <= 50; j++) {
                final String reverse = new StringBuilder(bi.toString()).reverse().toString();                
                bi = bi.add(new BigInteger(reverse));

                if (StringUtil.isPalindrome(bi.toString())) {
                    continue outer;
                }
            }
            lychrelCount++;
        }
        
        return lychrelCount;
    }

    public static void main(String[] args){
        System.out.println(problem55());
    }
}

