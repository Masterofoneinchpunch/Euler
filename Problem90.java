package com.mooip.code.projectEuler;

import com.mooip.code.recursive.CombinationsSize;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Cube digit pairs. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=90">Cube digit pairs</a>
 */
public final class Problem90 {
    private static final Set<String> twoDigitSquares = new HashSet<String>();
    static {
        twoDigitSquares.add("01");
        twoDigitSquares.add("04");
        twoDigitSquares.add("09");
        twoDigitSquares.add("16");
        twoDigitSquares.add("25");
        twoDigitSquares.add("36");
        twoDigitSquares.add("49");
        twoDigitSquares.add("64");
        twoDigitSquares.add("81");
    }
    
    public Problem90() {
    }

    //012345 012368, 012345 012389, 012348 012356, 012348 012359 examples that work.
    //answer is 1217
    public static long problem90() {           
        int distictArrangements = 0;
        CombinationsSize comb = new CombinationsSize("0123456789", 6);
        comb.combine();
        List<String> possibleDies = comb.getResult(); //size 210     

        for (int i = 0; i < possibleDies.size(); ++i) { 
            final String possibleDie = possibleDies.get(i);
            
            for (int j = i; j < possibleDies.size(); ++j) {
                final String possibleDie2 = possibleDies.get(j);
                if (hasAllTwoDigitSquareNumbers (possibleDie, possibleDie2)) {
                    //System.out.println("this works: " + possibleDie + " " + possibleDie2);
                    distictArrangements++;
                }               
            }
        }
        
        return distictArrangements;
    }

    private static boolean hasAllTwoDigitSquareNumbers(String possibleDie, String possibleDie2) {
        boolean hasAllTwoDigitSquareNumbers = true;
        possibleDie = possibleDie.replace('6', '9');
        possibleDie2 = possibleDie2.replace('6', '9');
             
        for (String digit : twoDigitSquares) {
            final String first = String.valueOf(digit.charAt(0)).replace('6', '9');
            final String second = String.valueOf(digit.charAt(1)).replace('6', '9');
            
            if ((possibleDie.contains(first) && possibleDie2.contains(second)) == false &&
               (possibleDie2.contains(first) && possibleDie.contains(second)) == false) {
                hasAllTwoDigitSquareNumbers = false;
                break;
            }            
        }
        
        return hasAllTwoDigitSquareNumbers;
    }
    
    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem90());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }   
}

