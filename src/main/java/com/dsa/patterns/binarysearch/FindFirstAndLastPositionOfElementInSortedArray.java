package com.dsa.patterns.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    private int findLeft(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int findRight(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
