package com.dsa.patterns.binarysearch;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println(splitArrayLargestSum.splitArray(new int[]{1, 4, 4}, 3));
    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canAchieve(mid, nums, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canAchieve(int mid, int[] nums, int k) {
        int minPartitions = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > mid) {
                minPartitions++;
                currentSum = 0;
            }
            currentSum += num;
        }
        return minPartitions <= k;
    }
}
