package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.HashSet;
import java.util.Set;

/**
 * Digit factorial chains. Slow solution.  Check out 74_1 for faster solution.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=74">Counting fractions in a range</a>
 */
public final class Problem74 {
    public Problem74() {
    }

    //answer is 402 (so far took 14 seconds)
    public static int problem74() {
        int countOver60 = 0;
        for (int i = 2; i < 1000000; i++) {
            Set<Long> factDigits = new HashSet<Long>();
            factDigits.add(Long.valueOf(i));
            
            Long addFactDigits = MathUtil.addFactorialDigits(String.valueOf(i));            
            while (factDigits.contains(addFactDigits) == false) {
                factDigits.add(addFactDigits);
                addFactDigits = MathUtil.addFactorialDigits(String.valueOf(addFactDigits));
            }
            
            if (factDigits.size() == 60) {
                countOver60++;
            }             
        }
        
        return countOver60;
    }

    public static void main(String[] args){
        System.out.println(problem74());
    }  
}

