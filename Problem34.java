package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Digit factorials.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=34">Digit factorials</a>
 */
public final class Problem34 {
    public Problem34() {
    }

    //answer is 40730
    public static long problem34() {   
        long factSum = 0;
        
        for (int num = 10; num <= 100000; num++) {
            final String number = Integer.toString(num);
            int sum = 0;
            for (int i = 0; i < number.length(); i++) {
                final String digit = number.substring(i, i+1);
                sum += MathUtil.factorial(Integer.valueOf(digit));
            }
            
            if (sum == num) {
                factSum += sum;
                System.out.println("BINGO: " + num);
            }
            
        }
        
        return factSum;
    }
    
    public static void main(String[] args){
        System.out.println(problem34());
    }    
}

