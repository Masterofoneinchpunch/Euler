package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import com.mooip.util.StringUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

// longest English language word: pneumonoultramicroscopicsilicovolcanokoniosis
/**
 * Coded triangle numbers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=42">Coded triangle numbers</a>
 */
public final class Problem42 {
    private static final Set<Integer> triangleNumbers = initializeTriangleNumbers();
    
    public Problem42() {
    }

    // formula tn = ½n(n+1)
    public static Set<Integer> initializeTriangleNumbers() {
        Set<Integer> triangleNumbersInit = new TreeSet<Integer>();
        
        for (int i = 1; i <= 43; i++) {
            triangleNumbersInit.add(MathUtil.triangleNumber(i));
        }
        
        return triangleNumbersInit;
    }
    
    //answer is 162
    public static long problem42() {   
        long triWordCount = 0;        
        
        try {
            final String fullPathName = "C:\\shawns" + File.separatorChar + "p042_words.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fullPathName));
            String input;            
            while ((input = reader.readLine()) != null) {
                input = input.replace("\"", ""); //remove quotes
                String words[] = input.split(",");
                for (int i = 0; i < words.length; i++) {
                    final int alphaScore = StringUtil.alphabeticScore(words[i]);
                    if (triangleNumbers.contains(alphaScore)) {
                        triWordCount++;
                    }
                }               
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
               
        return triWordCount;
    }
    
    public static void main(String[] args){
        System.out.println(problem42());
    }
}

