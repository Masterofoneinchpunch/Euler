package com.mooip.code.projectEuler;

import com.mooip.code.recursive.PermutationStrings;
import java.util.List;

/**
 * Sub-string divisibility.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=43">Sub-string divisibility</a>
 */
public final class Problem43 {
    public Problem43() {
    }

    //answer is 16695334890
    public static long problem43() {
        long sumOfPanDigitals = 0;
        
        List<String> ps = PermutationStrings.getPermutationStrings("1234567890");
        for (int i = 0; i < ps.size(); i++) {
            final String testNum = ps.get(i);
            if (testDivisible(testNum.substring(7, 10), 17) == false) {
                continue;
            }
            if (testDivisible(testNum.substring(6, 9), 13) == false) {
                continue;
            }
            if (testDivisible(testNum.substring(5, 8), 11) == false) {
                continue;
            }
            if (testDivisible(testNum.substring(4, 7), 7) == false) {
                continue;
            }
            if (testDivisible(testNum.substring(3, 6), 5) == false) {
                continue;
            }
            if (testDivisible(testNum.substring(2, 5), 3) == false) {
                continue;
            }
            if (testDivisible(testNum.substring(1, 4), 2) == false) {
                continue;
            }
            
            sumOfPanDigitals += Long.valueOf(testNum);
        }        

        return sumOfPanDigitals;
    }

    private static boolean testDivisible(String num, int divisor) {
        final Integer number = Integer.valueOf(num);        
        return (number % divisor == 0);
    }
    
    public static void main(String[] args){
        System.out.println(problem43());
    }   
}


