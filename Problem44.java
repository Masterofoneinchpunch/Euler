package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.Set;
import java.util.TreeSet;

/**
 * Pentagon numbers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=44">Pentagon numbers</a>
 */
public final class Problem44 {
    private static final Set<Integer> pentagonalNumbers = initializePentagonalNumbers();
    
    public Problem44() {
    }

    //answer is 5482660
    public static int problem44() {   
        Integer minDiff = null;
        
        for (int j = 1; j < 2500; j++) {
            for (int k = j+1; k < 2500; k++) {
                int sum = MathUtil.pentagonalNumber(j) + MathUtil.pentagonalNumber(k);
                int subtract = MathUtil.pentagonalNumber(k) - MathUtil.pentagonalNumber(j);
                if (pentagonalNumbers.contains(sum) && pentagonalNumbers.contains(subtract)) {
                    //System.out.println("we have: " + sum + " " + subtract + " for: " + j + " and " + k);
                    if (minDiff == null || subtract < minDiff) {
                        minDiff = subtract;
                    }                    
                }
            }
        }
        
        return minDiff;
    }

    private static Set<Integer> initializePentagonalNumbers() {
        Set<Integer> pentNumbers = new TreeSet<Integer>();
        
        for (int i = 1; i <= 3600; i++) {
            pentNumbers.add(MathUtil.pentagonalNumber(i));
        }
        
        return pentNumbers;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem44());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}

