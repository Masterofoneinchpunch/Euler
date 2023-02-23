package com.mooip.code.projectEuler;

/**
 * Special Pythagorean triplet. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=9">Special Pythagorean triplet</a>
 */
public final class Problem9 {
    public Problem9() {
    }

    //answer is 31875000
    public static long pythagoreanTriplet() {
        long product = 0;
        
        for (int a = 1; a < 400; a++) outer: {
            for (int b = a+1; b < 400; b++) {
                final int c = 1000 - b - a;
                final int a2 = a*a;
                final int b2 = b*b;
                final int c2 = c*c;
                
                if ((a2 + b2) == c2) {
                    System.out.println("winning combo: ");
                    System.out.println("a: " + a + " b: " + b + " c:" + c);
                    product = (long) a * b * c;
                    break outer;
                }
                
            }
        }
         
        return product;
    }
    
    public static void main(String[] args){
        System.out.println(pythagoreanTriplet());
    }
}


