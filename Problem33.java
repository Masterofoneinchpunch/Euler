package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Digit canceling fractions.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=33">Digit canceling fractions</a>
 */
public final class Problem33 {
    public Problem33() {
    }

    /*the four:
        16/64 = 1/4 : 0.25
        19/95 = 1/5 : 0.2
        26/65 = 2/5 : 0.4
        49/98 = 4/8 : 0.5
    */
    //answer is 100
    public static int problem33() {   
        int numMultiply = 1;
        int denumMultiply = 1;
        for (int num = 10; num <= 98; num++) {
            final String firstDigit = Integer.toString(num).substring(0, 1);
            final String secondDigit = Integer.toString(num).substring(1, 2);
            for (int denom = num + 1; denom <= 99; denom++) {
                final String denomStr = Integer.toString(denom);
                if (secondDigit.equals("0") && denomStr.substring(1, 2).equals("0")) {
                    continue;
                }
                double divide = (double) num / denom;
                if (denomStr.contains(secondDigit)) {
                    Integer newNum = Integer.valueOf(firstDigit);
                    Integer newDenom = Integer.valueOf(denomStr.replaceFirst(secondDigit, ""));
                    double divide2 = (double) newNum / newDenom;
                    if (divide == divide2) {
                        System.out.println(num + "/" + denom + " = " + newNum + "/" + newDenom + " : " + divide2);
                        int gcd = MathUtil.gcd(newNum, newDenom);
                        if (gcd != 1) {
                            newNum /= gcd;
                            newDenom /= gcd;
                            System.out.println(num + "/" + denom + " = " + newNum + "/" + newDenom + " : " + divide2);
                        }
                        numMultiply *= newNum;
                        denumMultiply *= newDenom;
                    }
                }
            }
        }
        
        denumMultiply /= MathUtil.gcd(numMultiply, denumMultiply);
        
        return denumMultiply;
    }
    
    public static void main(String[] args){
        System.out.println(problem33());
    }
}

