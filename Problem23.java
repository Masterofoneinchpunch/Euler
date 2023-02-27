package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Non-abundant sums.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=23">Non-abundant sums</a>
 */
public final class Problem23 {
    public Problem23() {
    }

    //answer is 4179871; took 4 seconds  
    public static long problem23() {     
        long sum = 0;
        
        List<Integer> abundentNumbers = new ArrayList<Integer>();
        Set<Integer> integers = new TreeSet<Integer>();
        for (int i = 1; i <= 28123; i++) {
            integers.add(i);
            final int sumProperDivisors = MathUtil.sumProperDivisors(i);
            if (sumProperDivisors > i) {
                abundentNumbers.add(i);
            }
        }
        
        // this needs to be all integers from 1 to 28123;
        for (int i = 0; i < abundentNumbers.size(); i++) {
            for (int j = 0; j < abundentNumbers.size(); j++) {
                final Integer sumOfTwo = abundentNumbers.get(i) + abundentNumbers.get(j);
                integers.remove(sumOfTwo);
            }
        }
        
        for (Integer numWOSum : integers) {
            sum += numWOSum;
        }
        
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println(problem23());
    }  
}
