package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;
import java.io.*;
import java.util.Arrays;

/**
 * Names scores.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=22">Names scores</a>
 */
public final class Problem22 {
    public Problem22() {
    }

    //answer is 871198282
    public static long problem22() {             
        long totalNameScore = 0;

        try {
            final String fullPathName = "C:\\shawns" + File.separatorChar + "p022_names.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fullPathName));
            
            String input;            
            while ((input = reader.readLine()) != null) {
                input = input.replace("\"", ""); //remove quotes
                String attributeNames[] = input.split(",");
                Arrays.sort(attributeNames);
                
                for (int i = 0; i < attributeNames.length; i++) {
                    int alphaScore = StringUtil.alphabeticScore(attributeNames[i]);
                    int nameScore = (i+1) * alphaScore;
                    totalNameScore += nameScore;
                }               
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
                
        return totalNameScore;
    }
    
    public static void main(String[] args){
        System.out.println(problem22());
    }  
}

