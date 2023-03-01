package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Maximum path sum II.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=67">Maximum path sum II</a>
 * @see <a href="https://projecteuler.net/problem=18">Maximum path sum I</a>
 */
public final class Problem67 {
    private static final int TRIANGLE_SIZE = 100;

    public Problem67() {
    }
    
    //https://projecteuler.net/problem=67
    //answer is 7273
    public static long problem67() {   
        int[][] triangle = new int[TRIANGLE_SIZE][];
        try {
            //populate triangle array
            int rowNum = 0;
            BufferedReader reader = IOUtil.getBufferedFileReader("C:\\shawns" + File.separatorChar + "p067_triangle.txt");
            String input;            
            while ((input = reader.readLine()) != null) {
                String[] lineNums = input.split(" ");
                
                int[] triangleRow = new int[lineNums.length];
                for (int i = 0; i < lineNums.length; i++) {
                    triangleRow[i] = Integer.valueOf(lineNums[i]);
                }
                triangle[rowNum] = triangleRow;
                
                rowNum++;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        
        //start from bottom up.  For each pair with the same parent choose the biggest value and add
        //that parent's value with the biggest value.  Continue this as you go up the pyramid.
        for (int i = TRIANGLE_SIZE - 1; i > 0; i--) {
            int[] triangleRow = triangle[i];
            for (int j = 0; j < triangleRow.length - 1; j++) {
                int rowNum1 = triangleRow[j];
                int rowNum2 = triangleRow[j+1];
                int biggerValue = (rowNum1 > rowNum2) ? rowNum1 : rowNum2;
                triangle[i-1][j] = triangle[i-1][j] + biggerValue;
            }
        }           
        
        return triangle[0][0];
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem67());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    } 
}

