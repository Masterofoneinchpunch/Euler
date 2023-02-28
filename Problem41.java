package com.mooip.code.projectEuler;

import com.mooip.code.recursive.PermutationNumbers;
import com.mooip.util.MathUtil;
import java.util.List;

/**
 * Pandigital prime.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=41">Pandigital prime</a>
 */
public final class Problem41 {
    public Problem41() {
    }

    //answer is 7652413
    /* I kept this in because of the algorithm which I will use later, but you can ignore a length 
       of 9 and a length of 8 because they add up to 3. I narrowed down considerably what was to be 
       used by doing a permutations on the pandigits so a nine-digit search is in ms.  
       The PermutationNumbers class grabs the permutations in descending order which also makes it 
       faster.
    */
    public static int problem41() {
        int largestPanDigitPrime = -1;
        String panDigits = "987654321";
        while (largestPanDigitPrime == -1) {
            final List<Integer> permNums = PermutationNumbers.getPermutationNumbers(panDigits);
            for (Integer permNum : permNums) {
                if (MathUtil.isPrime(permNum) == false) {
                    continue;
                }
                return permNum;
            }
            panDigits = panDigits.substring(1); // remove the first number
        }
        
        return largestPanDigitPrime;
    }
    
    public static void main(String[] args){
        System.out.println(problem41());
    }   
}

