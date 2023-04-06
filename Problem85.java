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
            int sideL = MathUtil.sumSequence(i);
            for (int j = i; j < 2001; j++) {
                int sideH = MathUtil.sumSequence(j);
                int totalRectangles = sideL * sideH;
                
                if (totalRectangles > NEAREST_TO) {
                    final int rightBefore = (sideL * MathUtil.sumSequence(j-1));
                    final int beforeDiff = NEAREST_TO - rightBefore;
                    if (beforeDiff < minDiff) {
                        //System.out.println("new min diff: " + beforeDiff);
                        //System.out.println("for " + i + " " + (j-1));
                        minDiff = beforeDiff;
                        lMinDiff = i;
                        hMinDiff = j-1;
                    }
                    
                    final int afterDiff = NEAREST_TO - rightBefore;
                    if (afterDiff < minDiff) {
                        //System.out.println("new min diff (after): " + afterDiff);
                        //System.out.println("for " + i + " " + j);
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
        System.out.println(Problem85());
    }   
}

