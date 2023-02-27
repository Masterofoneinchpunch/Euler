package com.mooip.code.projectEuler;

/**
 * Number spiral diagonals.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=28">Number spiral diagonals</a>
 */
public final class Problem28 {
    public Problem28() {
    }

    //https://projecteuler.net/problem=28 (spiral)
    //answer is 669171001
    public static int problem28(final int level) {   
        if (level % 2 == 0) {
            throw new IllegalArgumentException("The level has to be odd.");
        }
        int total = 1;
        int levelIncrement = 2;
        int revolveEdgeNum = 1;
        
        for (int i = 3; i <= level; i += 2) {
            for (int add = 1; add <= 4; add++) {
                revolveEdgeNum += levelIncrement;
                total += revolveEdgeNum;
            } 
            levelIncrement += 2; //every swirl this adds two
        }
        
        return total;
    }
    
    public static void main(String[] args){
        System.out.println(problem28(1001));
    }   
}
