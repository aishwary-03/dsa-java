package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class FindThePrefixCommonArrayOfTwoArrays {

    public static void main(String[] args) {
        FindThePrefixCommonArrayOfTwoArrays findThePrefixCommonArrayOfTwoArrays = new FindThePrefixCommonArrayOfTwoArrays();
        System.out.println(Arrays.toString(findThePrefixCommonArrayOfTwoArrays.findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3, 1, 2})));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] frequencyMap = new int[A.length];
        int[] c = new int[A.length];
        int commonCount = 0;
        for (int i = 0; i < c.length; i++) {
            frequencyMap[A[i] - 1]++;
            if (frequencyMap[A[i] - 1] == 2) commonCount++;

            frequencyMap[B[i] - 1]++;
            if (frequencyMap[B[i] - 1] == 2) commonCount++;

            c[i] = commonCount;
        }
        return c;
    }

}
