package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Factorial digit sum.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=20">Factorial digit sum</a>
 */
public final class Problem20 {
    public Problem20() {
    }

    //answer is 648
    public static long problem20() {     
        final BigInteger bi = MathUtil.getFactorial((short)100);
        
        System.out.println("bi: " + bi);
        
        return MathUtil.addStringDigits(bi.toString());
    }
    
    public static void main(String[] args){
        System.out.println(problem20());
    }   
}
