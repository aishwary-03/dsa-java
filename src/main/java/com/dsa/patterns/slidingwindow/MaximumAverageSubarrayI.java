package com.dsa.patterns.slidingwindow;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        double maxAverage = maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 1);
        System.out.println(maxAverage);
    }

    public double findMaxAverage(int[] nums, int k) {
        double tempSum = 0;
        for(int i =0; i < k; i++) {
            tempSum += nums[i];
        }
        double maxAverage = tempSum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i];
            tempSum -= nums[i-k];
            maxAverage = Math.max(maxAverage, tempSum);
        }
        return maxAverage / k;

    }

}
