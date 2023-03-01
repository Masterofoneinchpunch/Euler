package com.mooip.code.projectEuler;

import java.math.BigInteger;

/**
 * Powerful digit counts.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=63">Powerful digit counts</a>
 */
public final class Problem63 {
    public Problem63() {
    }

    //answer is 49
    public static long problem63() {   
        int digitCount = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 30; j++) {
                BigInteger bi = new BigInteger(String.valueOf(i));
                bi = bi.pow(j);
                int digits = String.valueOf(bi.toString()).length();
                System.out.println(i + " to the " + j + " = " + bi.toString());
                if (digits == j) {
                    System.out.println("same size above");
                    digitCount++;
                }
            }            
        }
        
        return digitCount;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem63());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    } 
}

