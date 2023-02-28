package com.mooip.code.projectEuler;

import java.util.Set;
import java.util.TreeSet;

/**
 * Pentagon numbers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=45">Pentagon numbers</a>
 */
public final class Problem45 {
    private static final Set<Long> pentagonalNumbers = initializePentagonalNumbers();
    private static final int MAX_NUM = 100000;
    
    public Problem45() {
    }

    //answer is 405939771
    public static long problem45() {   
        for (int i = 144; i < MAX_NUM; i++) {
            final long hexagonalNumber = hexagonalNumber(i);
            if (pentagonalNumbers.contains(hexagonalNumber)) {
                return hexagonalNumber;
            }
        }
        
        return -1;
    }

    private static Set<Long> initializePentagonalNumbers() {
        Set<Long> pentNumbers = new TreeSet<Long>();
        
        for (int i = 166; i <= MAX_NUM; i++) {
            pentNumbers.add(pentagonalNumber(i));
        }
        
        return pentNumbers;
    }

    // formula Hn=n(2n−1)
    private static long hexagonalNumber(int i) {
        return (long) i * (2*i - 1);
    }
    
    // formula Pn=n(3n−1)/2
    private static long pentagonalNumber(int i) {
        return (long) i * (3 * i - 1) / 2;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem45());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}

