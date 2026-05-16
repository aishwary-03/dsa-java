package com.dsa.patterns.binarysearch;

public class MinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        MinimumInRotatedSortedArrayII minimumInRotatedSortedArrayII = new MinimumInRotatedSortedArrayII();
        System.out.println(minimumInRotatedSortedArrayII.findMin(new int[]{3, 3, 1, 3}));
    }

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }

}
