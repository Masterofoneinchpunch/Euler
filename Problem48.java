package com.mooip.code.projectEuler;

import java.math.BigInteger;

/**
 * Self powers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=48">Self powers</a>
 */
public final class Problem48 {
    public Problem48() {
    }

    //answer is 9110846700
    public static String problem48() {   
        BigInteger addPowers = new BigInteger("0");
        
        for (int i = 1; i <= 1000; (i)++) {
            BigInteger bi = new BigInteger(String.valueOf(i));
            bi = bi.pow(i);
            addPowers = addPowers.add(bi);            
        }
        
        final String addPowersStr = addPowers.toString();                
        return addPowersStr.substring(addPowersStr.length() - 10);
    }

    public static void main(String[] args){
        System.out.println(problem48());
    } 
}

