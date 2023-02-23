package com.mooip.code.projectEuler;

/**
 * Digit fifth powers. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=30">Digit fifth powers</a>
 */
public final class Problem30 {
    public Problem30() {
    }

    //answer is 443839
    public static int problem30() {   
        int sum = 0;
        final int POWER = 5;
        
        for (int i = 10; i <= 900000; i++) {
            int sumOfDigits = 0;
            final String num = Integer.toString(i);
            for (int j = 0; j < num.length(); j++) {
                final int digit = Character.digit(num.charAt(j), 10);
                sumOfDigits += (int) Math.pow(digit, POWER);
            }
            
            if (sumOfDigits == i) {
                //System.out.println("sum = digits for: " + i);
                sum += sumOfDigits;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println(problem30());
    }   
}
