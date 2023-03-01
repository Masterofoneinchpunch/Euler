package com.mooip.code.projectEuler;

import com.mooip.util.MathUtil;
import java.math.BigInteger;
import java.util.TreeSet;

/**
 * Coin partitions.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=78">Coin partitions</a>
 * @see <a href="https://en.wikipedia.org/wiki/Partition_%28number_theory%29">Partition number theory</a>
 * @see <a href="https://www.youtube.com/watch?v=YQwGDINlIt8">YouTube Video</a>
 */
public final class Problem78 {
    public Problem78() {
    }

    //answer is 55374
    public static int problem78() {   
        final int MAX_TEST_NUM = 60000; 
        final BigInteger MILLION = new BigInteger("1000000");
        final BigInteger ZERO = new BigInteger("0");
        
        BigInteger partitionAmount;
        BigInteger[] partitions = new BigInteger[MAX_TEST_NUM];
        partitions[0] = new BigInteger("1");
        
        TreeSet<Integer> pentNumbers = new TreeSet(); // pentnumber never has to be bigger than n
        for (int i = 1; pentNumbers.isEmpty() || pentNumbers.last() < MAX_TEST_NUM; i++) {
            pentNumbers.add(MathUtil.pentagonalNumber(i));
            pentNumbers.add(MathUtil.pentagonalNumber(-i));
        }
               
        for (int n = 1; n < MAX_TEST_NUM; n++) {                        
            partitionAmount = ZERO;
            int i = 1;
            for (Integer pentNumb : pentNumbers.headSet(n, true)) {                
                final int prevPartition = n - pentNumb;
                if (Math.floor((i+1)/2) % 2 == 1) { 
                    partitionAmount = partitionAmount.add(partitions[prevPartition]);
                } else {
                    partitionAmount = partitionAmount.subtract(partitions[prevPartition]);
                }
                i++;
            }
            //System.out.println("pa: " + partitionAmount);
            if (partitionAmount.mod(MILLION).equals(ZERO)) {
                return n;
            }
            partitions[n] = partitionAmount;
        }
        
        return -1;
    }

    public static void main(String[] args){
        System.out.println(problem78());
    }   
}

