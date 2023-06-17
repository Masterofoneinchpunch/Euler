package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;

/**
 * Almost Equilateral Triangles. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=94">Almost Equilateral Triangles</a>
 */
public final class Problem94 {
    private static final int LIMIT = (int) Math.pow(10, 9);
    
    public Problem94() {
    }

    //I noticed that the area is all divisible by 12
    //answer is 
    public static long problem94() {
        long sum = 0;
        for (long i = 3; i < LIMIT / 3; i++) {
            boolean isValidTriangle = isValidTriangle(i,i,i-1);
            if (isValidTriangle) {
                System.out.println("for: " + i + "," + i + "," + (i-1));
                sum += (i + i + i - 1);
                i = i * 3 + 1;
            }
            isValidTriangle = isValidTriangle(i,i,i+1);
            if (isValidTriangle) {
                System.out.println("for: " + i + "," + i + "," + (i+1));
                sum += (i + i + i + 1);
                i = i * 3 + 1;
            }
        }
        
        return sum;
    }

    //Heron's Formula s = .5 * (a + b + c); sqrt(s(s-a)(s-b)(s-c))
    public static boolean isValidTriangle(long a, long b, long c) {
        final long sum = (long) a + b + c;
        if (sum % 2 != 0) {
            return false;
        }
        
        final long s = (long) sum / 2;   
        BigInteger bs = new BigInteger(String.valueOf(s));
        final long sa = (long) (s-a);
        BigInteger bsa = new BigInteger(String.valueOf(sa));
        final long sb = (long) (s-b);
        BigInteger bsb = new BigInteger(String.valueOf(sb));
        final long sc = (long) (s-c);
        BigInteger bsc = new BigInteger(String.valueOf(sc));
        BigInteger times = bs.multiply(bsa).multiply(bsb).multiply(bsc);
        BigInteger biSqrt = MathUtil.sqrt(times);

        if (biSqrt.multiply(biSqrt).equals(times)) {
            System.out.println("sum: " + sum);
            System.out.println("s: " + s);
            System.out.println("sa: " + sa + " sb: " + sb + " sc:" + sc);
            System.out.println("should be correct before sqrt: " + times);
            System.out.println("sqrt: " + biSqrt);
            System.out.println("sqrt 12: " + biSqrt.divide(new BigInteger("12")));
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args){
        System.out.println(problem94());        
    }   
}

