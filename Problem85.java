package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

/**
 * Counting rectangles. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=85">Counting rectangles</a>
 */
public final class Problem85 {
    private static final int NEAREST_TO = 2000000;
    
    public Problem85() {
    }

    //answer is 2772
    public static long Problem85() {   
        int minDiff = Integer.MAX_VALUE;
        int lMinDiff = 0;
        int hMinDiff = 0;
        for (int i = 1; i < 54; i++) {
            final int sideL = MathUtil.sumSequence(i);
            //always have j bigger or equal to i so no double counts; you do not have to go
            // higher than 2001 (and that is only for the first value
            for (int j = i; j < 2001; j++) { 
                final int sideH = MathUtil.sumSequence(j);
                final int totalRectangles = sideL * sideH;
                
                if (totalRectangles > NEAREST_TO) {
                    final int rightBefore = (sideL * MathUtil.sumSequence(j-1));
                    final int beforeDiff = NEAREST_TO - rightBefore;
                    if (beforeDiff < minDiff) {
                        minDiff = beforeDiff;
                        lMinDiff = i;
                        hMinDiff = j-1;
                    }
                    
                    final int afterDiff = NEAREST_TO - rightBefore;
                    if (afterDiff < minDiff) {
                        minDiff = afterDiff;
                        lMinDiff = i;
                        hMinDiff = j;
                    }
                                       
                    break;
                }
            }
        }
        
        return lMinDiff * hMinDiff;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(Problem85());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }   
}

