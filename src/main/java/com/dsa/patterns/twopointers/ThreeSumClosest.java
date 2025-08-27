package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int closestSum = threeSumClosest.threeSumClosest(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 1);
        System.out.println(closestSum);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                int difference = Math.abs(target - sum);
                if (difference < minDifference) {
                    closestSum = sum;
                    minDifference = difference;
                }
            }
        }
        return closestSum;
    }

}
