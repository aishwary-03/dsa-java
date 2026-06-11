package com.dsa.patterns.binarysearch;

public class HIndexII {

    public static void main(String[] args) {
        System.out.println(new HIndexII().hIndex(new int[]{1, 3, 5, 6}));
    }

    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= citations.length - mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return citations[low] >= citations.length - 1 ? citations.length - low : 0;
    }
}
