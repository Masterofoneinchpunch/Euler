package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;

/**
 * Number letter counts.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=17">Number letter counts</a>
 * @see <a href="https://bit.ly/41yuCwH">Help from how-to-convert-number-to-words-in-java.</a>
 */
public final class Problem17 {
    public Problem17() {
    }

    //answer is 21124
    public static int problem17() {     
        int length = 0;

        for (int i = 1; i <= 1000; i++) {
            final int numWordLength = StringUtil.numberAsWord(i).replaceAll("[- ]", "").length();
            System.out.println(StringUtil.numberAsWord(i) + " " + numWordLength);
            length += StringUtil.numberAsWord(i).replaceAll("[- ]", "").length();
        }
       
        return length;
    }
    
    public static void main(String[] args){
        System.out.println(problem17());
    }   
}