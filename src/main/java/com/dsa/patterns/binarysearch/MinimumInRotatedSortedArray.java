package com.dsa.patterns.binarysearch;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{5,1,2,3,4}));
    }

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
