package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Counting fractions in a range.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=73">Counting fractions in a range</a>
 */
public final class Problem73 {
    public Problem73() {
    }

    //answer is 7295372
    public static int Problem73() {   
        int runningCount = 0;
        final double lowerEnd = (double) 1/3;
        final double upperEnd = .5; // 1/2
        final int upperBound = 12000;
        
        for (int num = 2; num <= upperBound * upperEnd; num++) {
            for (int denom = num * 2; denom <= upperBound; denom++) {
                final double fraction = (double) num / denom;
                if (fraction <= lowerEnd) {
                    break;
                }
                if (MathUtil.isRelativelyPrime(num, denom)) {
                    runningCount++;
                }
            }
        }

        return runningCount;
    }

    public static void main(String[] args){
        System.out.println(Problem73());
    }  
}

