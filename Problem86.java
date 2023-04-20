package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Cuboid route. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=86">Cuboid route</a>
 * @see <a href="https://github.com/dcrousso/ProjectEuler/blob/master/PE086.java">A much better solution</a>
 */
public final class Problem86 { 
    private static int M = 100;
    private static final int SOLUTIONS_LIMIT = 1000000;
    
    public Problem86() {
    }

    //answer is 1818
    public static long Problem86() {   
        int distinctCuboids = 0;
        while (distinctCuboids < SOLUTIONS_LIMIT) {
            distinctCuboids = 0;
            M++; //this represents the level
            for (int m = 1; m <= Math.sqrt(2 * M); m++) { 
                for (int n = 1; n <= m; n++) {
                    if (MathUtil.isCoprime(m,n) == false || (m % 2 != 0 && n % 2 != 0)) {
                        continue;
                    }
                    final int a = m*m - n*n;
                    final int b = 2*m*n;           
                    for (int k = 1; k*a <= M || k*b <= M; k++) { 
                        final int ak = a * k;
                        final int bk = b * k;
                        if (ak <= M) {
                            final int dimenCombos = getDimensionCombos(ak,bk);
                            distinctCuboids += dimenCombos;
                        }
                        if (bk <= M) {
                            final int dimenCombos2 = getDimensionCombos(bk,ak);
                            distinctCuboids += dimenCombos2;
                        }
                    }
                }
            }
            System.out.println("distinctCuboids for M: " + M + " = " + distinctCuboids);
        }
        return M;
    }

    private static int getDimensionCombos(int a, int b_c) { 
        if (2*a < b_c) {
            return 0;
        }
        
        if (a >= b_c) {
            return b_c / 2;
        }
        
        return a - ((b_c - 1) / 2);
    }
    
    public static void main(String[] args){
        System.out.println(Problem86());
    }   
}

