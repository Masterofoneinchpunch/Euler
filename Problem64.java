package com.mooip.code.projectEuler;

import java.util.*;
        
/**
 * Odd period square roots.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=64">Odd period square roots</a>
 * @see https://math.stackexchange.com/questions/265690/continued-fraction-of-a-square-root
 * @see https://stackoverflow.com/questions/12182701/generating-continued-fractions-for-square-roots
 */
public final class Problem64 {
    public Problem64() {
    }

    //answer is 1322
    public static long problem64() {   
        int oddSqrRootCount = 0;
        int maxPeriodCount = 0;
        
        for (int i = 1; i <= 10000; i++) {
            Set<String> patterns = new HashSet<String>();
            int periodCount = 0;
            double sqrRt = Math.sqrt(i);
            int sqrInt = (int) Math.sqrt(i);
            if (sqrRt - sqrInt == 0) {
                continue;
            }
            
            int a = sqrInt;
            int p = 0;
            int q = 1;
            int j = 1;
            while (true) {
                p = (a * q) - p;
                //System.out.println("p " + p);
                q = (i - p*p) / q;
                //System.out.println("q " + q);
                a = (sqrInt + p) / q;
                //System.out.println("a" + j + " = " + a);
                j++;
                final String pgaPattern = p + " " + q + " " + a;
                if (patterns.contains(pgaPattern) == false) {
                    periodCount++;
                    patterns.add(pgaPattern);
                } else {                    
                    if (periodCount % 2 != 0) {
                        oddSqrRootCount++;
                    }
                    if (periodCount > maxPeriodCount) {
                        maxPeriodCount = periodCount;
                        System.out.println("new max period count for: " + i + ": " + maxPeriodCount);
                    }
                    break;
                }
            }           
        }
        
        return oddSqrRootCount;
    }
    
    public static void main(String[] args){
        System.out.println(problem64());
    }  
}
