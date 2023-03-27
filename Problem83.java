package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import com.mooip.util.StringUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Path sum: four ways. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=83">Path sum: four ways</a>
 * @see <a href="https://bit.ly/3LO8Mjn">Dijkstra's Algorithm in Project Euler# 83: Path sum: four ways</a>
 * @see https://en.wikipedia.org/wiki/Dijkstra's_algorithm 
 * @see https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm 
 * @see https://github.com/dcrousso/ProjectEuler/blob/master/PE083.java 
 */
public final class Problem83 {
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
    private static final int WIDTH = numbers[0].length;

    public Problem83() {
    }

    //answer is 425185
    public static long problem83() {
        System.out.println(StringUtil.matrixToString(numbers));
        
        //assign all values to the highest int (some algorithms says infiniti)
        int[][] distVal = new int[LENGTH][WIDTH];
        for(int y = 0; y < LENGTH; y++) {
            for(int x = 0; x < WIDTH; x++) {
                distVal[y][x] = Integer.MAX_VALUE; 
            }
        }
        
        // this is the Bellman–Ford algorithm
        distVal[0][0] = numbers[0][0]; //going to be this number since it is the starting point        
        for(int i = 0; i < LENGTH * WIDTH; i++) {
            for(int y = 0; y < LENGTH; y++) {
                for(int x = 0; x < WIDTH; x++) {
                    int temp = Integer.MAX_VALUE / 2; 
                    if(x >= 1) { //to the left
                        temp = Math.min(distVal[y][x - 1], temp); 
                    }
                    if(x < WIDTH - 1) { //to the right
                        temp = Math.min(distVal[y][x + 1], temp); 
                    }
                    if(y >= 1) { //look above
                        temp = Math.min(distVal[y - 1][x], temp); 
                    }
                    if(y < LENGTH - 1) { //look below
                        temp = Math.min(distVal[y + 1][x], temp); 
                    }
                    distVal[y][x] = Math.min(numbers[y][x] + temp, distVal[y][x]); 
                }
            }
        }

        System.out.println(StringUtil.matrixToString(numbers));
        System.out.println(StringUtil.matrixToString(distVal));
        
        return distVal[LENGTH - 1][WIDTH - 1];
    }

    private static int[][] readInMatrix() {
        int[][] matrix = new int[80][];
        try {
            int rowNum = 0;
            BufferedReader reader = IOUtil.getBufferedFileReader("C:\\shawns" + File.separatorChar + "p083_matrix.txt");
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
        System.out.println(problem83());
    }   
}

