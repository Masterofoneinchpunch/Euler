package com.mooip.code.projectEuler;

/**
 * Longest Collatz sequence.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=14">Longest Collatz sequence</a>
 */
public final class Problem14 {
    public Problem14() {
    }

    //answer is 837799
    public static int collatzSequence() {
        int biggestCollatz = 0;
        int biggestTermCount = 0;

        for (int i = 1; i <= 999999; i++) {
            int termCount = 1;
            long collatzTerm = i;
            while (collatzTerm > 1) {
                if (collatzTerm % 2 == 0) {
                    collatzTerm /= 2;
                    termCount++;
                } else {
                    collatzTerm = (collatzTerm * 3) + 1;
                    termCount++;
                }
            }
            
            if (termCount > biggestTermCount) {
                biggestTermCount = termCount;
                biggestCollatz = i;
            } 
        }
        
        System.out.println("last btc: " + biggestTermCount);
        return biggestCollatz;
    }
    
    public static void main(String[] args){
        System.out.println(collatzSequence());
    }   
}

