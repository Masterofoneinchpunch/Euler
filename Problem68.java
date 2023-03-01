package com.mooip.code.projectEuler;

import com.mooip.util.ListUtil;
import com.mooip.util.MathUtil;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Magic 5-gon ring.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=68">Magic 5-gon ring</a>
 */
public final class Problem68 {
    private static int highestLowestExternalNode = 0;
    private static final List<FiveGonRing> possCombos = new ArrayList<FiveGonRing>();
    private static FiveGonRing fiveGonRingCombo;
    
    public Problem68() {
    }
        
    //https://projecteuler.net/problem=68
    //answer is 6531031914842725 
    public static long problem68() {           
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        testForSums(nums);
        
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j < 10; j++) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                testForSums(nums);

                //swap back
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        System.out.println("All possible combos: ");
        for (FiveGonRing fiveGonRing : possCombos) {
            System.out.print("innerValues: " + fiveGonRing.getInnerValues());
            System.out.println(" outerValues: " + fiveGonRing.getOuterValues());
        }
        
        System.out.println("Combo to use: ");
        System.out.print("innerValues: " + fiveGonRingCombo.getInnerValues());
        System.out.println(" outerValues: " + fiveGonRingCombo.getOuterValues());
        
        List<List<Integer>> segments = fiveGonRingCombo.matchInnerTwo(highestLowestExternalNode);
        System.out.println("First segment: " + segments);
        segments = fiveGonRingCombo.matchNext(segments, false);
        System.out.println("next: " + segments);
        segments = fiveGonRingCombo.matchNext(segments, false);
        System.out.println("next2: " + segments);
        segments = fiveGonRingCombo.matchNext(segments, false);
        System.out.println("next3: " + segments);
        segments = fiveGonRingCombo.matchNext(segments, true);
        System.out.println("next4 (solves five gon): " + segments);

        Long largestNum = -1L;
        for (List<Integer> possChoice : segments) {
            Long num = ListUtil.listToNumber(possChoice);
            if (num > largestNum) {
                largestNum = num;
            }
        }
        
        return largestNum;
    }

    public static void testForSums(int[] nums) {
        int[] fhArrays = Arrays.copyOfRange(nums, 0, 5);
        int[] shArrays = Arrays.copyOfRange(nums, 5, 10);
        int firstHalf = (MathUtil.addAll(fhArrays) * 2);
        int secondHalf = MathUtil.addAll(shArrays);
        int totals = firstHalf + secondHalf;
        final int divideTotal = totals % 5;
        if (divideTotal == 0) {
            final int lowestExternalNode = MathUtil.minArray(shArrays);
            FiveGonRing fgr = new FiveGonRing(ListUtil.toList(fhArrays), ListUtil.toList(shArrays), (totals / 5));
            possCombos.add(fgr);
            if (lowestExternalNode > highestLowestExternalNode) {
                highestLowestExternalNode = lowestExternalNode;
                //this assumes there is only one choice (which there is, but maybe later a different problem
                //will have you choose from different numbered combos.
                fiveGonRingCombo = new FiveGonRing(ListUtil.toList(fhArrays), ListUtil.toList(shArrays), (totals / 5));
            }
        } 
    }
   
    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println(problem68());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }

    private static class FiveGonRing {        
        private List<Integer> innerValues = new ArrayList<Integer>();
        private List<Integer> outerValues = new ArrayList<Integer>();
        private final int lineTotal;
        
        public FiveGonRing(List<Integer> innerValues, List<Integer> outerValues, int lineTotal) {
            this.innerValues = innerValues;
            this.outerValues = outerValues;
            this.lineTotal = lineTotal;
        }

        public List<Integer> getInnerValues() {
            return this.innerValues;
        }

        public List<Integer> getOuterValues() {
            return this.outerValues;
        }
        
        public int getLineTotal() {
            return this.lineTotal;
        }

        public List<List<Integer>> matchInnerTwo(int startValue) {
            List<List<Integer>> canUse = new ArrayList<List<Integer>>();
            for (int i = 0; i < innerValues.size(); i++) {
                for (int j = i+1; j < innerValues.size(); j++) {
                    int total = innerValues.get(i) + innerValues.get(j) + startValue;
                    if (lineTotal == total) {
                        List<Integer> line = new ArrayList<Integer>();
                        line.add(startValue);
                        line.add(innerValues.get(i));
                        line.add(innerValues.get(j));
                        canUse.add(line);
                        List<Integer> line2 = new ArrayList<Integer>();
                        line2.add(startValue);
                        line2.add(innerValues.get(j));
                        line2.add(innerValues.get(i));
                        canUse.add(line2);

                        //System.out.println("total for " + startValue + " " + outerValues.get(i) + " " + outerValues.get(j) + " :" + total);
                    }
                }
            }
            this.outerValues.remove(new Integer(startValue));
            //System.out.println("can use: " + canUse);
            return canUse;
        }

        public List<List<Integer>> matchNext(List<List<Integer>> use, boolean lastSegment) {
            List<List<Integer>> canUse = new ArrayList<List<Integer>>();
            for (List<Integer> choices : use) {
                Integer secondNum = null;
                if (lastSegment) {
                    secondNum = choices.get(1);
                }
                int newMiddleNumber = choices.get(choices.size() - 1);

                List<Integer> outerToUse = ListUtil.minus(getOuterValues(), choices);
                for (Integer outerValue : outerToUse) {
                    int possibleThirdNum = lineTotal - outerValue - newMiddleNumber;
                    List<Integer> innerToUse = ListUtil.minus(getInnerValues(), choices);
                    if (lastSegment) {
                        innerToUse.add(secondNum);
                    }
                    if (possibleThirdNum != newMiddleNumber && innerToUse.contains(possibleThirdNum)) {
                        //System.out.println(outerValue + " " + newMiddleNumber + " " + possibleThirdNum);
                        List<Integer> newPoss = new ArrayList(choices);
                        newPoss.add(outerValue);
                        newPoss.add(newMiddleNumber);
                        newPoss.add(possibleThirdNum);
                        canUse.add(newPoss);
                    }
                }
            }

            return canUse;
        }
        
        @Override
        public String toString() {
            String newline = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();
            sb.append(newline);
            sb.append("innerValues: ").append(getInnerValues()).append(newline);
            sb.append("outerValues: ").append(getOuterValues()).append(newline);
            sb.append("lineTotal: ").append(getLineTotal()).append(newline);
            
            return sb.toString();
        }
    }
}