package com.mooip.code.projectEuler;

/**
 * Multiples of 3 or 5. 
 * <p>
 * The first problem for Project Euler is a simple one.
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=1">Multiples of 3 or 5</a>
 */
public final class Problem1 {
    public Problem1() {
    }

    //answer is 233168
    public static int problem1() {
        int sum = 0;
        for (int i = 3; i < 1000; ++i) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println(problem1());
    }    
}
