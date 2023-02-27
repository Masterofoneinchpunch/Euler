package com.mooip.code.projectEuler;

import com.mooip.util.DateUtil;

/**
 * Counting Sundays.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=19">Counting Sundays</a>
 */
public final class Problem19 {
    public Problem19() {
    }

    //answer is 171
    public static int problem19() {     
        int sundayCount = 0;

        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (DateUtil.findDay(month,1,year).equals("SUNDAY")) {
                    sundayCount++;
                }
            }
        }
        
        return sundayCount;
    }
    
    public static void main(String[] args){
        System.out.println(problem19());
    }  
}