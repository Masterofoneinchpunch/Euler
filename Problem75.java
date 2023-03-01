package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.HashSet;
import java.util.Set;

/**
 * Singular integer right triangles.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=75">Singular integer right triangles</a>
 * @see <a href="https://en.wikipedia.org/wiki/Pythagorean_triple">Pythagorean triple (formula here)</a>
 */
public final class Problem75 {
    public Problem75() {
    }

    //this has some similarities to problem 39
    //answer is 161667
    public static long problem75() {   
        Set<Integer> unique = new HashSet<Integer>();
        Set<Integer> allTotals = new HashSet<Integer>();
        
        for (int n = 1; n <= 1100; n++) { 
            for (int m = n+1; m <= 1100; m++) {
                if (MathUtil.isCoprime(m,n) == false || (m % 2 != 0 && n % 2 != 0)) {
                    continue;
                }
                
                final int a = m*m - n*n;
                final int b = 2*m*n;                               
                final int c = m*m + n*n;
                for (int k = 1; k < 125002; k++) { 
                    final int ak = a * k;
                    final int bk = b * k;
                    final int ck = c * k;
                    final int total = ak + bk + ck;
                    if (total > 1500000) {
                        //System.out.println("breaks at k: " + k + " m: " + m + " n: " + n);
                        break;
                    }
                    
                    if (allTotals.contains(total)) {
                        if (unique.contains(total)) {
                            unique.remove(total);
                        }                       
                    } else {
                        allTotals.add(total);
                        unique.add(total);
                    }                   
                }
            }
        }

        return unique.size();
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem75());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}

