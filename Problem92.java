package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Square Digit Chains. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=92">Square Digit Chains</a>
 * @note I did an approach with Sets (addAll needed to be used and it is a bit slow)
 * to try to interrupt the flow, but it actually slowed
 * it down compared to this brute force approach which is under a second.
 */
public final class Problem92 {
    public Problem92() {
    }

    //answer is 8581146; 
    public static long problem92() {   
        int arriveAt89Count = 0;
        
        for (int i = 1; i < 10000000; i++) { 
            long sumSquareDigits = i;
            while (sumSquareDigits != 1 && sumSquareDigits != 89) {
                sumSquareDigits = MathUtil.addSquareDigits(sumSquareDigits);
            }
            
            if (sumSquareDigits == 89) {
                arriveAt89Count++;
            }           
        }
        
        return arriveAt89Count;
    }

    public static void main(String[] args){
        System.out.println(problem92());
    }   
}
