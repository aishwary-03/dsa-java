package com.dsa.patterns.binarysearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        System.out.println(findKthSmallestPairDistance.smallestDistancePair(new int[]{1, 3, 1}, 1));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (countPairsWithDistLeqX(mid, nums) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int countPairsWithDistLeqX(int mid, int[] nums) {
        int count = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) left++;
            count += right - left;
        }

        return count;
    }
}
