package com.dsa.patterns.revisit;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int minDifference = Integer.MAX_VALUE;
        int closest = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;

                int difference = Math.abs(target - sum);
                if (difference < minDifference) {
                    minDifference = difference;
                    closest = sum;
                }

                if (sum > target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return closest;
    }


}
