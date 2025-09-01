package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class TwoSumLessThanK {

    public static void main(String[] args) {
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int maxSum = twoSumLessThanK.maxSum(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60);
        System.out.println(maxSum);
    }

    public int maxSum(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int maxSum = -1;
        while (left < right) {
            int tempSum = nums[left] + nums[right];
            if (tempSum < k) {
                left++;
                maxSum = Math.max(maxSum, tempSum);
            } else {
                right--;
            }
        }
        return maxSum;
    }

}
