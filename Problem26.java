package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Reciprocal cycles.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=26">Reciprocal cycles</a>
 */
public final class Problem26 {
    public Problem26() {
    }

    //answer is 983
    public static int problem26() {   
        int maxlength = -1;
        int largestValueWithRepeating = -1;
        BigDecimal bd = new BigDecimal(1);
        System.out.println(bd.scale()); 
        final int SCALE = 2000;
        
        for (int i = 2; i < 1000; i++) {
            BigDecimal divisor = new BigDecimal(i);
            BigDecimal result = bd.divide(divisor, SCALE, RoundingMode.HALF_UP);
            result = result.stripTrailingZeros();
            String resultStr = result.toString();
            resultStr = resultStr.replace("0.", "");
            
            if (resultStr.length() < 100) {
                System.out.println("i: " + i + " SCALE: " + resultStr.length() + " " + resultStr);
                continue;
            }
            final String repeatingPattern = StringUtil.longestRepeatingPattern(resultStr);
            if (maxlength < repeatingPattern.length()) {
                System.out.println("i: " + i + " length: " + repeatingPattern.length() + " " + repeatingPattern);
                maxlength = repeatingPattern.length();
                largestValueWithRepeating = i;
            }
        }
        
        
        return largestValueWithRepeating;
    }
       
    public static void main(String[] args){
        System.out.println(problem26());
    }    
}

