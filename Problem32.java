package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;
import java.util.Set;
import java.util.TreeSet;

/**
 * Pandigital products.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=32">Pandigital products</a>
 */
public class Problem32 {

    public Problem32() {
    }

    //answer is 45228
    public static int problem32() {  
        Set<Integer> products = new TreeSet<Integer>(); 
        int sum = 0;
        
        for (int multiplicand = 1; multiplicand < 2000; multiplicand++) {
            for (int multiplier = 1; multiplier < 500; multiplier++) {
                final int product = multiplicand * multiplier;
                StringBuilder sb = new StringBuilder("");
                sb.append(multiplicand).append(multiplier).append(product);
                //the length check speeds this up quite a bit
                if (StringUtil.isPanDigitalNine(sb.toString()) == false) {
                    continue;
                }
                products.add(product);
            }           
        }
        for (Integer product : products) {
            sum += product;
        }
        
        return sum;
    }
    
    public static void main(String[] args){
        System.out.println(problem32());
    }

    
}
