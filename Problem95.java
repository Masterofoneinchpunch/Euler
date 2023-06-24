package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;

import java.util.HashMap;
import java.util.Map;

import java.util.HashSet;
import java.util.Set;

/**
 * Amicable Chains. 
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=95">Amicable Chains</a>
 */
public final class Problem95 {
    private static final int MAX_VALUE = 1000000;
    private static final Map<Integer,Integer> nextSum = new HashMap<Integer,Integer>();
    public Problem95() {
    }

    //answer is 14316; currently taking way too long (1 minute 11 s)
    public static long problem95() {   
        int maxSteps = 0;
        int smallLongNum = -1;
        //StringBuilder sb = new StringBuilder("");
        
        for (int i = 1; i <= 100000; i++) {
            Set<Integer> prevValues = new HashSet<Integer>();
            prevValues.add(i);
            int sum;
            if (nextSum.containsKey(i)) {
                sum = nextSum.get(i);
            } else {
                sum = MathUtil.sumProperDivisors(i);
            }
            
            int steps = 1;
            //System.out.print("i: " + i + " " + sum);
            //sb.append("i: ").append(i).append(" ").append(sum);
            while (sum != 0 && sum <= MAX_VALUE) {
                if (sum == i) {
                    //System.out.print(" amicable for:" + i);
                    //sb.append(" amicable for:").append(i);
                    if (maxSteps < steps) {
                        maxSteps = steps;
                        //System.out.print(" steps: " + maxSteps);
                        //sb.append(" steps: ").append(maxSteps);
                        //System.out.println(sb);
                        smallLongNum = i;
                    }
                    break;
                }
                final int newSum;
                if (nextSum.containsKey(sum)) {
                    newSum = nextSum.get(sum);
                } else {
                    newSum = MathUtil.sumProperDivisors(sum);
                    nextSum.put(sum, newSum);
                }
                steps++;
                //System.out.print(" " + newSum);
                //sb.append(" ").append(newSum);
                if (prevValues.contains(sum)) {
                    //System.out.print(" break continous loop");
                    //sb.append(" break continous loop");
                    //System.out.println(sb);
                    break;
                }
                prevValues.add(sum);
                sum = newSum;
            }
            
            //System.out.println("");
            //System.out.println(sb);
            //sb.setLength(0);
        }
        
        return smallLongNum;
    }

    public static void main(String[] args){
        System.out.println(problem95());
        
        //System.out.println(MathUtil.sumProperDivisors2(12496));
        //System.out.println(MathUtil.sumProperDivisors(12496));
    }   
}
