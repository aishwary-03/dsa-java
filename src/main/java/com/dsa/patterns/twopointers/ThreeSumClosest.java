package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = new int[]{0, 0, 0};
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }

    private int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int minDifference = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                int difference = Math.abs(target - sum);
                if (difference < minDifference) {
                    minDifference = difference;
                    closest = sum;
                }
            }
        }
        return closest;

    }

}
