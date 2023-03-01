package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * XOR decryption.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=59">XOR decryption</a>
 */
public final class Problem59 {
    public Problem59() {
    }

    //key is exp
    //answer is 129448
    public static long problem59() {   
        
        Scanner scanner = IOUtil.getScanner("C:\\shawns" + File.separatorChar + "p059_cipher.txt");
        scanner.useDelimiter(",");
        List<Integer> values = new ArrayList<Integer>();
        Integer input;
        while (scanner.hasNextInt()) {
            input = scanner.nextInt();
            values.add(input);
        }

        //testAllLetters(values); //this is how I figured out exp
        return letterComboDecrypt('e', 'x', 'p', values);
    }

    private static void testAllLetters(List<Integer> values) {
        final int startPoint = (int) 'a';
        for (int i = 0; i < 26; i++) {                
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    final int firstLetter =  (startPoint + i);
                    final int secondLetter = (startPoint + j);
                    final int thirdLetter = (startPoint + k);
                    int letterCount = 1;
                    System.out.println("for: " + (char) firstLetter + (char) secondLetter + (char) thirdLetter);
                    for (int l = 0; l < 25; l++) {
                        int useLetter;
                        
                        switch (letterCount) {
                            case 1:
                                useLetter = firstLetter;
                                break;
                            case 2:
                                useLetter = secondLetter;
                                break;
                            default: 
                                useLetter = thirdLetter;
                                letterCount = 0;
                                break;
                        }
                        letterCount++;
                        System.out.print((char) (values.get(l) ^ useLetter));
                    }
                    System.out.println("");
                }
            }
        }
    }

    private static int letterComboDecrypt(int firstLetter, int secondLetter, int thirdLetter, List<Integer> values) { 
        int asciiSum = 0;
        int letterCount = 1;
        System.out.println("for: " + (char) firstLetter + (char) secondLetter + (char) thirdLetter);
        for (int l = 0; l < values.size(); l++) {
            int useLetter;

            switch (letterCount) {
                case 1:
                    useLetter = firstLetter;
                    break;
                case 2:
                    useLetter = secondLetter;
                    break;
                default: 
                    useLetter = thirdLetter;
                    letterCount = 0;
                    break;
            }
            letterCount++;
            final int asciiValue = (values.get(l) ^ useLetter);
            asciiSum += asciiValue;
            System.out.print((char) asciiValue);
        }
        System.out.println("");
        return asciiSum;
    }
    
    public static void main(String[] args){
        System.out.println(problem59());
    }  
}

