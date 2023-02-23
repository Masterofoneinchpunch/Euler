package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;

/**
 * Largest palindrome product. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=4">Largest palindrome product</a>
 */
public final class Problem4 {
    public Problem4() {
    }

    //answer is 906609
    public static int problem4() {
        int maxPalidrome = 0;
        for (int i = 1; i < 999; i++) {
            for (int j = 1; j < 999; j++) {
                final int product = i * j;
                if (StringUtil.isPalindrome(Integer.toString(product)) && maxPalidrome < product) {
                    maxPalidrome = product;
                }
            }
        }
        return maxPalidrome;
    }
    
    public static void main(String[] args){
        System.out.println(problem4());
    }
}

