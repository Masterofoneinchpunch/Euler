package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Prime pair sets.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=60">Prime pair sets</a>
 */
public final class Problem60 {
    private static final int MIN_NUM = 1; 
    private static final int MAX_NUM = 10000;
    private static final TreeSet<Integer> primesMin = new TreeSet(MathUtil.getPrimes(MIN_NUM, MAX_NUM));

    public Problem60() {
    }

    //answer is 26033
    public static int problem60() {
        Integer lowestTotal = null;
        TreeSet<Integer> subSet = new TreeSet<Integer>(primesMin.subSet(0, 100));
        
        List<List<Integer>> primeConcats = new ArrayList<List<Integer>>();
        for (Integer prime : subSet) { 
           for (Integer prime2 : primesMin.tailSet(prime, false)) {
               if (concatPrime(prime, prime2)) {
                   List<Integer> primes = new ArrayList();
                   primes.add(prime);
                   primes.add(prime2);
                   primeConcats.add(primes);
               }              
           } 
        }
        
        for (List<Integer> primeConcat : primeConcats) {
            Integer max = Collections.max(primeConcat);
            for (Integer prime : primesMin.tailSet(max, false)) {
                if (concatPrime(primeConcat, prime)) {
                    primeConcat.add(prime);
                    if (primeConcat.size() >= 5) {
                        System.out.println("we have fifth or more: " + primeConcat);
                        int total = MathUtil.addAll(primeConcat);
                        if (lowestTotal == null || total < lowestTotal) {
                            lowestTotal = total;
                        }
                    }                    
                }
            }
        } 
        return lowestTotal;
    }

    private static boolean concatPrime(List<Integer> primes, Integer newValue) {
        for (Integer prime : primes) {
            if (concatPrime(prime, newValue) == false) {
                return false;
            }            
        }
        return true;
    }
    
    private static boolean concatPrime(Integer firstPrime, Integer secondPrime) {
        String testBefore = Integer.toString(firstPrime) + Integer.toString(secondPrime);
        String testAfter = Integer.toString(secondPrime) + Integer.toString(firstPrime);
        if (MathUtil.isPrime(Long.valueOf(testBefore)) && MathUtil.isPrime(Long.valueOf(testAfter))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){        
        System.out.println(problem60());
    } 
}


