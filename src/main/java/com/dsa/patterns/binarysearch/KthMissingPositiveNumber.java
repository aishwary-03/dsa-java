package com.dsa.patterns.binarysearch;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        KthMissingPositiveNumber kthMissingPositiveNumber = new KthMissingPositiveNumber();
        System.out.println(kthMissingPositiveNumber.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    }

    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] - mid - 1 < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
        return low + k;
    }
}
