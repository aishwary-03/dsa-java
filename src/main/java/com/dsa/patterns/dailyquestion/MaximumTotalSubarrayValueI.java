package com.dsa.patterns.dailyquestion;

public class MaximumTotalSubarrayValueI {

    public static void main(String[] args) {
        MaximumTotalSubarrayValueI maximumTotalSubarrayValueI = new MaximumTotalSubarrayValueI();
        System.out.println(maximumTotalSubarrayValueI.maxTotalValue(new int[]{1, 3, 2}, 2));
    }

    public long maxTotalValue(int[] nums, int k) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (max - min) * k;
    }
}
