package com.mooip.code.projectEuler;

/**
 * Even Fibonacci numbers. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=2">Even Fibonacci numbers</a>
 */
public final class Problem2 {
    public Problem2() {
    }

    //answer is 4613732
    public static int problem2() {
        int second_prev = 1;
        int prev = 2;
        int fibonacci = 0; 
        int evenSum = 2;
        for (int i = 3; fibonacci <= 4000000; ++i) {
            fibonacci = second_prev + prev;
            if (fibonacci % 2 == 0) {
                evenSum += fibonacci;
            }
            //System.out.println(fibonacci);
            second_prev = prev;
            prev = fibonacci;
        }
        
        return evenSum;
    }
    
    public static void main(String[] args){
        System.out.println(problem2());
    } 
}

