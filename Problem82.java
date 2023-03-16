package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public final class Problem82 {
    /*
    // Testing values
    private static final int[][] numbers = {
        {131, 673, 234, 103, 18},
        {201, 96, 342, 965, 150},
        {630, 803, 746, 422, 111},
        {537, 699, 497, 121, 956},
        {805, 732, 524, 37, 331} };
    */
    private static final int[][] numbers = readInMatrix();
    private static final int LENGTH = numbers.length;
    
    public Problem82() {
    }

    //answer is 260324
    public static long problem82() {
        long minPathSum = Long.MAX_VALUE;
        for (int i = LENGTH - 1; i >= 0; i--) {
            final int WIDTH = numbers[i].length;
            for (int j = WIDTH - 1; j >= 0; j--) {
                //skip the back row
                if (i < LENGTH - 1) {
                    final int rightAfter  = numbers[j][i+1]; // row, column
                    int replace = rightAfter;
                    if (j > 0) {
                        //need to get least path above and right, but it is possible that you
                        //have to go more than one above and this assignment you will.
                        int aboveTotal = 0;
                        for (int k = j; k > 0; k--) {
                            final int above = numbers[k-1][i];
                            aboveTotal += above;
                            if (aboveTotal > replace) {
                                break;
                            }
                            final int raAbove = numbers[k-1][i+1];
                            final int total = aboveTotal + raAbove;
                            if (total < replace) {
                                replace = total;
                                //System.out.print(numbers[j][i] + " will be replaced by " + replace);
                            } 
                        }
                    }
                    if (j < WIDTH - 1) {
                        //when you check below you only have to check the number below as it
                        //will already include the sum you are looking for.
                        final int total = numbers[j+1][i];
                        if (total < replace) {
                            replace = total;
                        }
                    }
                    numbers[j][i] += replace;
                }
                
                if (i == 0) {
                    final long firstColumnTotal = numbers[j][i];
                    if (firstColumnTotal < minPathSum) {
                        minPathSum = firstColumnTotal;
                    }
                }
            }
        }
        
        return minPathSum;
    }      

    private static int[][] readInMatrix() {
        int[][] matrix = new int[80][];
        try {
            int rowNum = 0;
            BufferedReader reader = IOUtil.getBufferedFileReader("C:\\shawns" + File.separatorChar + "p082_matrix.txt");
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
        long startTime = System.nanoTime();
        System.out.println(problem82());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }   
}

