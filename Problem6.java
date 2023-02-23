package com.mooip.code.projectEuler;

/**
 * Sum square difference. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=6">Sum square difference</a>
 */
public final class Problem6 {
    public Problem6() {
    }

    //answer is 25164150
    public static int problem6() {
        int sumSquared = 0;
        int sum = 0;
        
        for (int i = 1; i <= 100; i++) {
            sumSquared += (i * i);
            sum += i;
        }
        
        final int squaredSum = sum * sum;
        return squaredSum - sumSquared;
    }
    
    public static void main(String[] args){
        System.out.println(problem6());
    }   
}


