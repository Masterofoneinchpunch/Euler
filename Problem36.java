package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;
import java.math.BigInteger;

/**
 * Double-base palindromes.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=36">Double-base palindromes</a>
 */
public final class Problem36 {
    public Problem36() {
    }

    //https://projecteuler.net/problem=36
    //answer is 872187
    public static long problem36() {   
        long factSum = 0;        
        
        for (int i = 1; i < 1000000; i++) {
            final String value = String.valueOf(i);
            if (value.endsWith("0") || StringUtil.isPalindrome(value) == false) {
                continue;
            }
            final BigInteger bi = new BigInteger(value);
            final String binary = bi.toString(2);
            if (binary.endsWith("0") || StringUtil.isPalindrome(binary) == false) {
                continue;
            }
            //System.out.println("both: " + i + " " + binary);
            factSum += i;
       }
               
       return factSum;
    }
    
    public static void main(String[] args){
        System.out.println(problem36());
    }
}
