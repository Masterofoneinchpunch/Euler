package com.mooip.code.projectEuler;

/**
 * Maximum path sum I.
 * <p>
 * This is the same type of problem as 67.  I have a much better solution for 67, but I
 * kept this one for recursion sake (it is so much slower).
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=18">Maximum path sum I</a>
 * @see <a href="https://projecteuler.net/problem=67">Maximum path sum II</a> 
 * My solution for 67 is better solution than this one.
 */
public final class Problem18 {
    private static final int[][] triangle = {
        {75},
        {95, 64},
        {17, 47, 82},
        {18, 35, 87, 10},
        {20,  4, 82, 47, 65},
        {19,  1, 23, 75,  3, 34},
        {88,  2, 77, 73,  7, 63, 67},
        {99, 65,  4, 28,  6, 16, 70, 92},
        {41, 41, 26, 56, 83, 40, 80, 70, 33},
        {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
        {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
        {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
        {63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        {04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23} };

    private static int maxTotal = 0;
    private static int totalPaths = 0;
    
    public Problem18() {
    }

    //answer is 1074
    public static int problem18() {     
        travelTriangle(0,0,0);
               
        return maxTotal;
    }
    
    //brute force recursive algorithm traveling array pyramid
    private static void travelTriangle(int i, int j, int pathTotal) {       
        if (i < triangle.length) {
            if (i == triangle.length - 1) {
                totalPaths++;
            }
            pathTotal += triangle[i][j];
                    
            if (maxTotal < pathTotal) {
                maxTotal = pathTotal;
            }
            System.out.println("i, j: " + i + " " + j + " " + triangle[i][j]);
            travelTriangle(i+1,j, pathTotal);
            travelTriangle(i+1,j+1, pathTotal);
        }
    }
    
    public static void main(String[] args){
        System.out.println(problem18());
        System.out.println("Total Paths: " + totalPaths);
    }   
}