package com.mooip.code.projectEuler;

import com.mooip.code.recursive.Permutations;

/**
 * Lexicographic permutations.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=24">Lexicographic permutations</a>
 */
public final class Problem24 {
    public Problem24() {
    }

    //answer is 2783915460; The answer is outputted in the Permutations class.
    public static int problem24() {     
        Permutations.permutationString("0123456789");
        
        return -1;
    }
    
    public static void main(String[] args){
        System.out.println(problem24());
    }   
}