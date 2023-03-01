package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Digit factorial chains. Faster solution.  Check out 74 for slower solution.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=74">Counting fractions in a range</a>
 */
public final class Problem74_1 {
    public Problem74_1() {
    }

    //https://projecteuler.net/problem=74
    //answer is 402 (less than a second; much faster)
    public static int problem74() {
        int countAt60 = 0;
        Map<Long, Integer> factorialNRCount = new HashMap<Long, Integer>();
        for (int i = 2; i < 1000000; i++) {
            Set<Long> factDigits = new HashSet<Long>();
            factDigits.add(Long.valueOf(i));
            
            Long addFactDigits = MathUtil.addFactorialDigits(String.valueOf(i));
            final Long firstAddFactDigits = addFactDigits;
            final int size;
            if (factorialNRCount.containsKey(firstAddFactDigits) == false) {
                while (factDigits.contains(addFactDigits) == false) {
                    factDigits.add(addFactDigits);
                    addFactDigits = MathUtil.addFactorialDigits(String.valueOf(addFactDigits));
                }
                factorialNRCount.put(firstAddFactDigits, factDigits.size());
                size = factDigits.size();
            } else {
                size = factorialNRCount.get(firstAddFactDigits);
            }
            if (size == 60) {
                countAt60++;
            }             
        }
        
        return countAt60;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem74());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}

