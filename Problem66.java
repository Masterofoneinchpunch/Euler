package com.mooip.code.projectEuler;

import java.math.BigInteger;

/**
 * Diophantine equation.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=66">Diophantine equation</a>
 * @see <a href="https://euler.stephan-brumme.com/66/">One solution</a>
 * @see <a href="https://github.com/dcrousso/ProjectEuler/blob/master/PE066.java">I really liked this solution</a>
 * @see <a href="http://mathworld.wolfram.com/PellEquation.html">This one was quite helpful especially with formula</a>
 * @see <a href="https://en.wikipedia.org/wiki/Pell%27s_equation">Pell's Equation</a>
 */
public final class Problem66 {
    public Problem66() {
    }

    //answer is 661
    public static long problem66() {   
        BigInteger largestX = BigInteger.ZERO;
        int largestD = 0;
        
        //formula: x2 – Dy2 = 1
        for (int d = 2; d <= 1000; d++) {
            BigInteger sqrt = BigInteger.valueOf((int) Math.sqrt(d));
            if(sqrt.pow(2).compareTo(BigInteger.valueOf(d)) == 0) {
                continue;
            }
            BigInteger p = BigInteger.ZERO;
            BigInteger q = BigInteger.ONE;
            BigInteger a = sqrt; //example for each a of sqr 13 [a0;a1,a2,a3,a4,a5] is [3;1,1,1,1,6]
            //System.out.println("for d: " + d);
            //System.out.println("a0: " + a);
            BigInteger x = a, x0 = BigInteger.ONE, tempX = x0;
            BigInteger y = BigInteger.ONE, y0 = BigInteger.ZERO, tempY = y0;
            //int count = 1;
            while(x.pow(2).subtract(y.pow(2).multiply(BigInteger.valueOf(d))).compareTo(BigInteger.ONE) != 0) {
                p = q.multiply(a).subtract(p); //p = (a * q) - p;
                q = BigInteger.valueOf(d).subtract(p.pow(2)).divide(q); //q = (d - p*p) / q;
                a = sqrt.add(p).divide(q); //a = (sqrt + p) / q;
                //System.out.println("a" + count + ": " + a);
                //System.out.println("p: " + p);
                //System.out.println("q: " + q);
                //count++;
                //Set previous x & y (i.e. d - 1)
                tempX = x0; 
                tempY = y0;
                //Set current x & y (i.e. d)
                x0 = x; 
                y0 = y;
                //Set next x & y (i.e. d + 1) using continued fraction expansion
                x = x.multiply(a).add(tempX); 
                y = y.multiply(a).add(tempY); 
                //System.out.println("x: " + x);
                //System.out.println("y: " + y);
            }
            
            if (x.compareTo(largestX) > 0) {
                largestX = x;
                largestD = d;
                System.out.println("largestX: " + x + " for: " + largestD);
            }
            
        }
        
        return largestD;
    }
    
    public static void main(String[] args){
        System.out.println(problem66());
    }
}
