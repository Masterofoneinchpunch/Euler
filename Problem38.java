package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;

/**
 * Pandigital multiples.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=38">Pandigital multiples</a>
 */
public final class Problem38 {
    public Problem38() {
    }

    //answer is 932718654
    public static int problem38() {   
        int largestPanDigital = -1;
        for (int i = 9; i < 9999; i++) {
            String concatNum = "";
            for (int j = 1; j <= 5; j++) {
                concatNum += (i * j);
                if (concatNum.length() > 9) {
                    break;
                }
                if (StringUtil.isPanDigitalNine(concatNum)) {
                    final int concat = Integer.valueOf(concatNum);
                    if (largestPanDigital < concat) {
                        largestPanDigital = concat;
                    }
                    System.out.println("PAN: " + concatNum + " for " + i);
                }
            }            
        }
        
        return largestPanDigital;
    }
    
    public static void main(String[] args){
        System.out.println(problem38());
    }
}
