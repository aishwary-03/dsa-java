package com.dsa.patterns.slidingwindow;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int minSubArrayLength = minimumSizeSubarraySum.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(minSubArrayLength);
    }


    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int tempSum = 0;
        for (int right = 0; right < nums.length; right++) {
            tempSum = tempSum + nums[right];
            while (tempSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                tempSum = tempSum - nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
