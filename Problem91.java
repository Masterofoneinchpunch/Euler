package com.mooip.code.projectEuler;

/**
 * Right triangles with integer coordinates. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=91">Right triangles with integer coordinates</a>
 */
public final class Problem91 {
    private static final int GRID_SIZE = 50;
    
    public Problem91() {
    }

    //answer is 14234
    public static long problem91() {   
        //three types of triangles (right angle on origin, x-axis. y-axis) will have a count of grid number * 3; it is the fourth case
        //where the right angle is not on the x or y-axis that makes this problem more difficult.
        final int grid = GRID_SIZE * GRID_SIZE;       
        int rightTriangles = grid * 3;
        System.out.println("total right angle on origin, x-axis. y-axis " + rightTriangles);
        //the above code is not used; kept for possible algorithm later.
        
        int rightTriCount = 0;
        for (int x1 = 0; x1 <= GRID_SIZE; x1++) {
            for (int y1 = 0; y1 <= GRID_SIZE; y1++) {
                for (int x2 = x1; x2 <= GRID_SIZE; x2++) { //x2 can always be bigger or equal than x1
                    for (int y2 = y1; y2 >= 0; y2--) { //y2 is always equal or smaller than y1
                        if (isRightTriangle(x1, y1, x2, y2)) {
                            System.out.println("rt: x1: " + x1 + " y1: " + y1 + " x2: " + x2 + " y2: " + y2);
                            rightTriCount++;
                        }
                    }
                }
            }
        }
               
        return rightTriCount;
    }

    
    // Tests whether the three points {(0,0), (x1,y1), (x2,y2)} form a right triangle.
    //One point of this triangle will always be (0,0).  To get the length of the sides 
    //(the key is the Pythagorean Theorem; square the x1 and add the square of the y1
    //do the same for the x2 and y2 value
    //notice that if a value is along an axis it will be a zero value for one set
    //and you are explicitely doing the formula a2 + b2 = c2.
    //since the long side can be potentially any side you have to test for all three.
    private static boolean isRightTriangle(int x1, int y1, int x2, int y2) {
        //these two checks remove non-triangles (which test positive)
        if (x1 == x2 && y1 == y2) {
            return false;
        }
        if (x1 == 0 && y1 == 0 || x2 == 0 && y2 == 0) {
            return false;
        }
        final int side1 = x1 * x1 + y1 * y1;
        final int side2 = x2 * x2 + y2 * y2;
        final int side3 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        return side1 + side2 == side3
            || side2 + side3 == side1
            || side3 + side1 == side2;
    }    
    
    public static void main(String[] args){
        System.out.println(problem91());
    }   
}

