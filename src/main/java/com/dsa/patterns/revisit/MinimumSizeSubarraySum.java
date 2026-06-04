package com.dsa.patterns.revisit;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(1, new int[]{1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int totalSum = 0;
        while (end < nums.length) {
            totalSum += nums[end];
            while (totalSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                totalSum -= nums[start];
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
