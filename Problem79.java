package com.mooip.code.projectEuler;

import com.mooip.util.CollectionsUtil;
import com.mooip.util.IOUtil;
import com.mooip.util.ListUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Passcode derivation. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=79">Passcode derivation</a>
 */
public final class Problem79 {
    public Problem79() {
    }

    //answer is 73162890
    /**
     * The algorithm here is to pass through and grab each a character that is in the beginning,
     * but not in anything after.  If you want to make this quicker you can do the same thing for
     * the last character (but this solution was solved almost instantly).  This solution is
     * predicated on there only being one character used (this is not mentioned in the problem).
     * This like the 5-gon problem (problem 68 {@link com.mooip.code.projectEuler.Problem68}) I was
     * able to solve first by hand before I coded it.
     * 
     * @return passcode The minimum passcode.
     */
    public static String problem79() {
        List<Character> passcode = new ArrayList<Character>();
        List<String> passcodes = new ArrayList<String>();        
        Set<Character> notFirst = new HashSet<Character>();
        Set<Character> first = new HashSet<Character>();
        
        //you could avoid figuring out the first character here (you can also figure out the last here),
        //but it saves one interation doing this.
        try {
            final String fullPathName = "C:\\shawns" + File.separatorChar + "p079_keylog.txt";
            BufferedReader reader = IOUtil.getBufferedFileReader(fullPathName);
            String input;            
            while ((input = reader.readLine()) != null) {
                passcodes.add(input);
                first.add(input.charAt(0));
                
                for (int i = 1; i < input.length(); i++)  {
                    notFirst.add(input.charAt(i));
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        passcode.add(CollectionsUtil.getFirstMinus(first, notFirst));
        System.out.println("passcode " + passcode); //here is the first number of the passcode.
        notFirst.clear();
        first.clear();        
        
        /* 
           Keep looking for the only character (after considering the ones chosen already) that
           does not have any characters before it.
        */
        while (true) {    
            for (String passcodeStr : passcodes) {
                Character firstCharacter = null;
                for (int i = 0; i < passcodeStr.length(); i++) {
                    if (passcode.contains(passcodeStr.charAt(i)) == false && firstCharacter == null) {
                        firstCharacter = passcodeStr.charAt(i);
                        first.add(firstCharacter);
                    } else if (passcode.contains(passcodeStr.charAt(i)) == false && firstCharacter != null) {
                        notFirst.add(passcodeStr.charAt(i));
                    }
                }
            }
            if (notFirst.isEmpty() && first.isEmpty()) {
                break;
            }
            
            passcode.add(CollectionsUtil.getFirstMinus(first, notFirst));
            System.out.println("passcode " + passcode); //you can see the progression with each number here.
            notFirst.clear();
            first.clear();        
        }
             
        return ListUtil.listToString(passcode);
    }

    public static void main(String[] args){
        System.out.println(problem79());
    }   
}


