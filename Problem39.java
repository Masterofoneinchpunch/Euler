package com.mooip.code.projectEuler;

/**
 * Integer right triangles.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=39">Integer right triangles</a>
 */
public final class Problem39 {
    public Problem39() {
    }

    //answer is 840
    public static int problem39() {   
        int maxSolutionNum = 0;
        int maxSolution = -1;
        
        for (int p = 12; p <= 1000; p++) {
            int intSolutionAmount = 0;
            for (int c = p/3; c < p/2 ; c++) {
                final int cSqu = c * c;
                for (int b = c - 1; b >= c/2; b--) {
                    int a = p - c - b;
                    if (a > b) {
                        break;
                    }
                    if (cSqu == ((b * b) + (a * a))) {
                        intSolutionAmount++;
                    }
                }
            }
            System.out.println("p: " + p + " int solution amount: " + intSolutionAmount);
            if (maxSolutionNum < intSolutionAmount) {
                maxSolutionNum = intSolutionAmount;
                maxSolution = p;
            }
        }
        
        return maxSolution;
    }
    
    public static void main(String[] args){
        System.out.println(problem39());
    }
}

