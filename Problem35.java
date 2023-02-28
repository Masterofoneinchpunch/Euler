package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import com.mooip.util.StringUtil;

/**
 * Circular primes.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=35">Circular primes</a>
 */
public final class Problem35 {
    public Problem35() {
    }

    //answer is 55
    public static int problem35() {   
        int circularPrimesCount = 1; //2 is first prime
        outer: 
        for (int i = 3; i < 1000000; i += 2) {            
            String numStr = Integer.toString(i);
            if (StringUtil.matchRegex("[02468]+", numStr)) {
                continue;
            }
            if (MathUtil.isPrime(i) == false) {
                continue;
            }
            for (int j = 1; j < numStr.length(); j++) {
                numStr = numStr.substring(1, numStr.length()) + numStr.substring(0,1);
                
                if (MathUtil.isPrime(Long.valueOf(numStr)) == false) {
                    continue outer;
                }
            }
            System.out.println(numStr); 
            circularPrimesCount++;
        }
        
        return circularPrimesCount;
    }
        
    public static void main(String[] args){
        System.out.println(problem35());
    }   
}
