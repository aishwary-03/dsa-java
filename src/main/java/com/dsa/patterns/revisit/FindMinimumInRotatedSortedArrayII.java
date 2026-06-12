package com.dsa.patterns.revisit;

public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArrayII();
        System.out.println(findMinimumInRotatedSortedArray.findMin(new int[]{11, 13, 15, 17}));
    }

    private int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
