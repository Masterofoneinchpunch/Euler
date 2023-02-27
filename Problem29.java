package com.mooip.code.projectEuler;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

/**
 * Distinct powers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=29">Distinct powers</a>
 */
public final class Problem29 {
    public Problem29() {
    }

    //https://projecteuler.net/problem=29
    //answer is 9183
    public static int problem29() {   
        Set<BigDecimal> distinctTerms = new TreeSet<BigDecimal>();
        
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                final BigDecimal bd = new BigDecimal(i);
                distinctTerms.add(bd.pow(j));
            }
        }
        
        return distinctTerms.size();
    }
    
    public static void main(String[] args){
        System.out.println(problem29());
    }   
}
