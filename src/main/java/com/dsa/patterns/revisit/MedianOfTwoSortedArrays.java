package com.dsa.patterns.revisit;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {
            int cutA = low + (high - low) / 2;
            int cutB = (m + n + 1) / 2 - cutA;

            int maxLeftA = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            int minRightA = cutA == m ? Integer.MAX_VALUE : nums1[cutA];
            int maxLeftB = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];
            int minRightB = cutB == n ? Integer.MAX_VALUE : nums2[cutB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftA, maxLeftB);
                } else {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                }
            } else if (maxLeftA > minRightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return 0;
    }
}
