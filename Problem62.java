package com.mooip.code.projectEuler;

import com.mooip.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Cubic permutations.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=62">Cubic permutations</a>
 */
public final class Problem62 {
    public Problem62() {
    }

    //answer is 127035954683
    public static long problem62() {   
        HashMap<String, List<Long>> hashMap = new HashMap();
        for (int i = 4642; i < 8642; i++) {
            final long cube = quickCube(i);
            final String sortedString = StringUtil.sortString(String.valueOf(cube));
            
            if (hashMap.containsKey(sortedString)) {
                List<Long> numberMatches = hashMap.get(sortedString);
                numberMatches.add(cube);
                if (numberMatches.size() == 5) {
                    System.out.println("winner:" + numberMatches);
                    return Collections.min(numberMatches);
                }               
            } else {
                List<Long> cubes = new ArrayList();
                cubes.add(cube);
                hashMap.put(sortedString, cubes);
            }            
        }
        
        return -1;
    }

    private static long quickCube(int i) {
        return ((long) i * i * i);
    }
    
    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem62());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }  
}

