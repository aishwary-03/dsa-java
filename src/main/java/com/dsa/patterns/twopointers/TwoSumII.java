package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] nums = new int[] {-1, 0};
        System.out.println(Arrays.toString(twoSumII.twoSum(nums, -1)));
    }

    private int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};

    }
}
