package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import com.mooip.code.recursive.PermutationStrings;
import java.util.*;

/**
 * Cyclical figurate numbers.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=61">Cyclical figurate numbers</a>
 */
public final class Problem61 {
    private static final TreeSet<Integer> pentagonalNumbers = initializePentagonalNumbers();
    private static final TreeSet<Integer> triangleNumbers = initializeTriangleNumbers();
    private static final TreeSet<Integer> squareNumbers = initializeSquareNumbers();
    private static final TreeSet<Integer> hexagonalNumbers = initalizeHexagonalNumbers();
    private static final TreeSet<Integer> heptagonalNumbers = initalizeHeptagonalNumbers();
    private static final TreeSet<Integer> octagonalNumbers = initalizeOctogonalNumbers();
    
    private static final Map<Integer, TreeSet<Integer>> nums = new HashMap<Integer, TreeSet<Integer>>();
    
    static {
        nums.put(1, squareNumbers);
        nums.put(2, pentagonalNumbers);
        nums.put(3, hexagonalNumbers);
        nums.put(4, heptagonalNumbers);
        nums.put(5, octagonalNumbers);
    }

    public Problem61() {
    }

    private static TreeSet<Integer> initalizeOctogonalNumbers() {
        TreeSet<Integer> octagonalNumbers = new TreeSet<Integer>();
        
        for (int i = 19; i < 59; i++) {
            octagonalNumbers.add(MathUtil.octagonalNumber(i));
        }
        System.out.println("oct nums: " + octagonalNumbers);
        return octagonalNumbers;
    }
    
    private static TreeSet<Integer> initalizeHeptagonalNumbers() {
        TreeSet<Integer> heptagonalNumbers = new TreeSet<Integer>();
        
        for (int i = 21; i < 64; i++) {
            heptagonalNumbers.add(MathUtil.heptagonalNumber(i));
        }
        System.out.println("hept nums: " + heptagonalNumbers);
        return heptagonalNumbers;
    }
    
    private static TreeSet<Integer> initializeSquareNumbers() {
        TreeSet<Integer> squareNumbers = new TreeSet<Integer>();
        
        for (int i = 33; i < 100; i++) {
            squareNumbers.add(i * i);
        }
        System.out.println("square nums: " + squareNumbers);
        return squareNumbers;
    }
    
    private static TreeSet<Integer> initalizeHexagonalNumbers() {
        TreeSet<Integer> hexagonalNumbers = new TreeSet<Integer>();
        
        for (int i = 23; i < 71; i++) {
            hexagonalNumbers.add(MathUtil.hexagonalNumber(i));
        }
        System.out.println("hex nums: " + hexagonalNumbers);
        return hexagonalNumbers;
    }
    
    private static TreeSet<Integer> initializePentagonalNumbers() {
        TreeSet<Integer> pentagonalNumbers = new TreeSet<Integer>();
        
        for (int i = 26; i <= 81; i++) {
            pentagonalNumbers.add(MathUtil.pentagonalNumber(i));
        }
        System.out.println("pent nums: " + pentagonalNumbers);
        return pentagonalNumbers;
    }
    
    private static TreeSet<Integer> initializeTriangleNumbers() {
        TreeSet<Integer> triangleNumbers = new TreeSet<Integer>();
        
        for (int i = 45; i < 141; i++) {
            int triangleNumber = MathUtil.triangleNumber(i);
            triangleNumbers.add(triangleNumber);
        }
        System.out.println("tri nums: " + triangleNumbers);
        return triangleNumbers;
    }

    //https://projecteuler.net/problem=61
    //answer is 28684
    public static long problem61() {
        int permSum = -1;
        List<String> perms = PermutationStrings.getPermutationStrings("12345");
        
        /*
        * If you start with tri numbers the only potentional two set value is for square (1225, 1296).
        * (1600, 1681) does not work for squares since 1600 cannot be used (third digit is a 0).  Also when
        * start with tri numbers it makes the permutation count a lot less (one less factorial).
        */
        for (Integer tri : triangleNumbers) {
            for (String perm : perms) {
                final int listSum = goThruPermNums(perm, tri);
                if (listSum != -1) {
                    permSum = listSum;
                }
            }
        }
        
        return permSum;
    }

    private static int goThruPermNums(String perm, Integer tri) {
        int permSum = -1;
        String triStr = String.valueOf(tri);
        String lastTwoDigits = triStr.substring(2, 4);
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(tri);
        
        for (int i = 0; i < perm.length(); i++) {
            int listToCheck = Character.digit(perm.charAt(i), 10);
            Set<Integer> cc = containsCyclical(nums.get(listToCheck), lastTwoDigits);
            if (cc.isEmpty()) {
                break;
            }
            
            for (Integer value : cc) {
                numList.add(value);
                if (cc.size() > 1) {
                    //here is where I would work with special case
                }
                lastTwoDigits = String.valueOf(value).substring(2, 4);
            }
        }
        // out of all the permutations there are six cases where there are seven values because of
        // square (1225, 1296), I got the answer so I did not need to work those special cases.
        if (numList.size() >= 6) {
            System.out.println(numList);
            if (numList.size() == 6 && lastTwoDigits.equals(triStr.substring(0, 2))) {
                //I wanted to go and see all the combinations, but you could return here since 
                //there is only one value.
                System.out.println("here: " + numList);
                permSum = MathUtil.listSum(numList);
            }
        }
        
        return permSum;
    }
    
    private static Set<Integer> containsCyclical(TreeSet<Integer> values, String twoDigits) {
        return values.subSet(Integer.valueOf(twoDigits + "10"), Integer.valueOf(twoDigits + "99"));
    }
    
    public static void main(String[] args){
        System.out.println(problem61());
    }
}

