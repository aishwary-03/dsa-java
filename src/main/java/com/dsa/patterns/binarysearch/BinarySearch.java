package com.dsa.patterns.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[] {5};
        System.out.println(binarySearch.search(nums, 5));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left= mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

}
