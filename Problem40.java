package com.mooip.code.projectEuler;

public class Problem40 {

    public Problem40() {
    }

    //https://projecteuler.net/problem=40
    //answer is 210
    public static long problem40() {   
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < 200000; i++) {
            sb.append(i);
        }
        
        return 1 * conv(sb.charAt(10-1)) * conv(sb.charAt(100-1)) * conv(sb.charAt(1000-1)) * conv(sb.charAt(10000-1)) * conv(sb.charAt(100000-1)) * conv(sb.charAt(1000000-1));
    }

    private static int conv(char num) {
        return Character.digit(num, 10);
    }
    
    public static void main(String[] args){
        System.out.println(problem40());
    }
   
}

