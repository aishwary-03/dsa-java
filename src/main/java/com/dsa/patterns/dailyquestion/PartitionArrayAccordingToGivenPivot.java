package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot {

    public static void main(String[] args) {
        PartitionArrayAccordingToGivenPivot partitionArrayAccordingToGivenPivot = new PartitionArrayAccordingToGivenPivot();
        System.out.println(Arrays.toString(partitionArrayAccordingToGivenPivot.pivotArray(new int[]{-3, 4, 3, 2}, 2)));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];

        int left = 0;
        int pivotCount = 0;

        for (int num : nums) {
            if (num < pivot) {
                ans[left] = num;
                left++;
            }
            if (num == pivot) pivotCount++;
        }

        while (pivotCount > 0) {
            ans[left] = pivot;
            left++;
            pivotCount--;
        }

        for (int num : nums) {
            if (num > pivot) {
                ans[left] = num;
                left++;
            }
        }
        return ans;
    }

}
