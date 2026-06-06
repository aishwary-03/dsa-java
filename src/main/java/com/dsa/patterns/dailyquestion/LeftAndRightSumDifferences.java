package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class LeftAndRightSumDifferences {

    public static void main(String[] args) {
        LeftAndRightSumDifferences leftAndRightSumDifferences = new LeftAndRightSumDifferences();
        System.out.println(Arrays.toString(leftAndRightSumDifferences.leftRightDifference(new int[]{1})));
    }

    public int[] leftRightDifference(int[] nums) {
        int[] result = new int[nums.length];

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftSum;
            leftSum += nums[i];
        }

        int rightSum = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = Math.abs(result[i] - rightSum);
            rightSum += nums[i];
        }
        return result;
    }

}
