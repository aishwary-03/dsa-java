package com.dsa.patterns.binarysearch;

public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        PeakIndexInAMountainArray peakIndexInAMountainArray = new PeakIndexInAMountainArray();
        System.out.println(peakIndexInAMountainArray.peakIndexInMountainArray(new int[]{20, 10, 5, 2}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
