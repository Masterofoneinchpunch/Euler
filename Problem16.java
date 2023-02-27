package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Power digit sum.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=16">Power digit sum</a>
 */
public final class Problem16 {   
    public Problem16() {
    }
    
    //answer is 1366
    public static long problem16() {
        BigInteger bi = new BigInteger("2");
        
        bi = bi.pow(1000);
        
        return MathUtil.addStringDigits(bi.toString());
    }
    
    public static void main(String[] args){
        System.out.println(problem16());
    }   
}

