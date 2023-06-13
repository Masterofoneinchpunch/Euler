package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import com.mooip.code.recursive.PermutationsRepetition;
import com.mooip.code.recursive.PermutationStrings;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Arithmetic Expressions. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=93">Arithmetic Expressions</a>
 */
public final class Problem93 {
    private static final List<String> opPerms = PermutationsRepetition.getPermutationStrings("*/+-", 3);
    public Problem93() {
    }

    //answer is 1258 (maxOrderString: 1258 with 51 in a row)
    //current time is 17 minutes 33 seconds (way too slow; I will need another approach)
    //1258
    //integers size: 68
    //integers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 55, 56, 57, 64, 70, 72, 75, 78, 79, 80, 81, 82, 85, 88, 90, 96, 120]
    //conOrder: 51
    public static String problem93() {
        String maxOrderString = "";
        int longestConOrder = 0;
        int count = 0;
        for (int a = 1; a < 7; a++) {
            for (int b = a+1; b < 8; b++) {
                for (int c = b+1; c < 9; c++) {
                    for (int d = c+1; d < 10; d++) {
                        String numSet = a + "" + b + "" + c + "" + d;
                        count++;
                        System.out.println(numSet);
                        int maxConOrder = getMaxOrder(numSet);
                        if (maxConOrder > longestConOrder) {
                            longestConOrder = maxConOrder;
                            maxOrderString = numSet;
                        }
                    }
                }
            }
        }
        System.out.println("count: " + count);
        
        System.out.println("maxOrderString: " + maxOrderString + " with " + longestConOrder);
        return maxOrderString;
    }

    private static int getMaxOrder(String numStr) {
        Set<Integer> integers = new TreeSet<Integer>();
        final List<String> permNums = PermutationStrings.getPermutationStrings(numStr);       
        for (String perm : permNums) {
            final int[] digits = new int[4];
            //System.out.println(perm);
            digits[0] = Character.digit(perm.charAt(0), 10);
            digits[1] = Character.digit(perm.charAt(1), 10);
            digits[2] = Character.digit(perm.charAt(2), 10);
            digits[3] = Character.digit(perm.charAt(3), 10);
            
            for (String opPerm : opPerms) {
                final char[] ops = new char[3];
                ops[0] = opPerm.charAt(0);
                ops[1] = opPerm.charAt(1);
                ops[2] = opPerm.charAt(2);
                
                compose(digits, ops, new String[] {"","","","","",""}, integers);
                
                if (ops[0] == ops[1] && ops[1] ==  ops[2]) {
                    continue;
                }
                
                compose(digits, ops, new String[] {"(","",")","","",""}, integers);
                compose(digits, ops, new String[] {"","(","","",")",""}, integers);
                compose(digits, ops, new String[] {"","","","(","",")"}, integers);
                compose(digits, ops, new String[] {"(","","","",")",""}, integers);
                compose(digits, ops, new String[] {"","(","","","",")"}, integers);
                compose(digits, ops, new String[] {"(","(","","","))",""}, integers);
                compose(digits, ops, new String[] {"((","",")","",")",""}, integers);
                compose(digits, ops, new String[] {"","(","","(","","))"}, integers);
                compose(digits, ops, new String[] {"","((","","",")",")"}, integers);
            }           
        }
        
        System.out.println("integers size: " + integers.size());
        System.out.println("integers: " + integers);
        
        int maxOrder = 1;
        for (Integer order : integers) {
            if (order == maxOrder) {
                maxOrder++;
            } else {
                break;
            }
        }
        maxOrder = --maxOrder;
        System.out.println("conOrder: " + maxOrder);
        return maxOrder;
    }
    
    public static void compose(int[] digits, char[] ops, String[] parens, Set<Integer> integers) {
        StringBuilder sb = new StringBuilder();
        sb.append(parens[0]);
        sb.append(digits[0]).append("").append(ops[0]).append(parens[1]);
        sb.append(digits[1]).append(parens[2]).append(ops[1]).append(parens[3]);
        sb.append(digits[2]).append(parens[4]).append(ops[2]).append("");
        sb.append(digits[3]).append(parens[5]);
        //System.out.println("compose: " + sb);
        Double result = MathUtil.eval(sb.toString());
        if ((result % 1) == 0 && result > 0) {
            integers.add(result.intValue());
        }
    }
    
    public static void main(String[] args){
        System.out.println(problem93());
    }   
}
