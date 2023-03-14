package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Path sum: two ways. This will be familiar to problem 67 when you think about the 
 * end first.  This is a dynamic programming solution (I tried a recursive solution and 
 * knew that it would not work for the larger problem and of course work for the shorter problem).
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=81">Path sum: two ways</a>
 * @see <a href="https://projecteuler.net/problem=67">Maximum path sum II</a> This really helped.
 * I did not even realize I was doing a dynamic programming solution here.  For me this was easier 
 * to visualize than this one at first (which is why I kept in the souts.)
 */
public final class Problem81 {
    /* Testing values
    private static final int[][] numbers = {
        {131, 673, 234, 103, 18},
        {201, 96, 342, 965, 150},
        {630, 803, 746, 422, 111},
        {537, 699, 497, 121, 956},
        {805, 732, 524, 37, 331} };
    */
    private static final int[][] numbers = readInMatrix();
    private static final int LENGTH = numbers.length;
    
    public Problem81() {
    }

    //answer is 427337
    public static long problem81() {      
        for (int i = LENGTH - 1; i >= 0; i--) {
            final int WIDTH = numbers[i].length;
            for (int j = WIDTH - 1; j >= 0; j--) {               
                if (i < LENGTH - 1 && j < WIDTH - 1) {
                    //System.out.println("for: " + numbers[i][j]);
                    //System.out.println("checks : " + numbers[i][j+1] + " and " + numbers[i+1][j]);
                    numbers[i][j] += Math.min(numbers[i][j+1], numbers[i+1][j]);
                } else if (j < WIDTH - 1) {
                    //System.out.println("bottom row: ");
                    numbers[i][j] += numbers[i][j+1];
                } else if (i < LENGTH - 1) {
                    //System.out.println("back column: ");
                    numbers[i][j] += numbers[i+1][j];
                }
            }
        }
      
        return numbers[0][0];
    }

    private static int[][] readInMatrix() {
        int[][] matrix = new int[80][];
        try {
            int rowNum = 0;
            BufferedReader reader = IOUtil.getBufferedFileReader("C:\\shawns" + File.separatorChar + "p081_matrix.txt");
            String input;            
            while ((input = reader.readLine()) != null) {
                String[] lineNums = input.split(",");
                
                int[] matrixRow = new int[lineNums.length];
                for (int i = 0; i < lineNums.length; i++) {
                    matrixRow[i] = Integer.valueOf(lineNums[i]);
                }
                matrix[rowNum] = matrixRow;
                
                rowNum++;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return matrix;
    }
    
    public static void main(String[] args){
        System.out.println(problem81());
    }   
}


