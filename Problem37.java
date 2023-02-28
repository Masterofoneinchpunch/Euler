package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import com.mooip.util.StringUtil;

public final class Problem37 {
    public Problem37() {
    }

    //https://projecteuler.net/problem=37
    //answer is 748317
    public static long problem37() {   
        long primeSum = 0;        
        int count = 0;
        
        outer:
        for (int i = 23; count < 11; i += 2) {            
            final String numStr = Integer.toString(i);
            if (StringUtil.matchRegex("[0468]+", numStr)) {
                continue;
            }
            if (StringUtil.matchRegex("^[19]", numStr) || StringUtil.matchRegex("[1259]$", numStr)) {
                continue;
            }
            if (MathUtil.isPrime(i) == false) {
                continue;
            }
            //trunc left
            for (int j = 1; j < numStr.length(); j++) {
                final int leftTrunc = Integer.valueOf(numStr.substring(j, numStr.length()));
                if (MathUtil.isPrime(leftTrunc) == false) {
                    continue outer;
                }
            }
            //trunc right
            for (int j = 1; j < numStr.length(); j++) {
                final int rightTrunc = Integer.valueOf(numStr.substring(0, numStr.length() - j));
                if (MathUtil.isPrime(rightTrunc) == false) {
                    continue outer;
                }
            }

            count++;
            System.out.println("prime: " + i);
            primeSum += i;            
       }
               
       return primeSum;
    }
    
    public static void main(String[] args){
        System.out.println(problem37());
    }   
}


