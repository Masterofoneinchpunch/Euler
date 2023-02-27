package com.mooip.code.projectEuler;

import com.mooip.code.recursive.LatticePath;

/**
 * Lattice paths.
 * <p>
 * This is way slower than I would like, but I want to keep an example of a lattice path
 * recursion solution.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=15">Lattice paths</a>
 */
public final class Problem15 {  
    public Problem15() {
    }
    
    //answer is 137846528820
    public static long problem15() {
        return LatticePath.compute(20,20);
    }
    
    public static void main(String[] args){
        System.out.println(problem15());
    }   
}
