package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import com.mooip.util.StringUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Roman numerals. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=89">Roman numerals</a>
 */
public final class Problem89 {
    //4 in a row of the same character and the first character in front if exists
    private static final String REGEX = "[IVXLCDM]?([IVXLCD])\\1{3}"; 
    private static int numCharsSaves = 0;
   
    public Problem89() {
    }

    //answer is 743
    public static long Problem89() {   
        try {
            BufferedReader reader = IOUtil.getBufferedFileReader("C:\\shawns" + File.separatorChar + "p089_roman.txt");
            String input;            
            while ((input = reader.readLine()) != null) {
                List<String> matches = StringUtil.getMatches(REGEX, input);
                if (matches.isEmpty() == false) {
                    for (String match : matches) {
                        //System.out.println("matches: " + match);
                        if (match.equals("VIIII") || match.equals("LXXXX") || match.equals("DCCCC")) {
                            numCharsSaves += 3;
                        } else {
                            numCharsSaves += 2;
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        
        return numCharsSaves;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(Problem89());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }   
}

