package com.dsa.patterns.binarysearch;

public class SearchInASortedArrayOfUnknownSize {

    private interface ArrayReader {
        int get(int index);
    }

    public static void main(String[] args) {
        SearchInASortedArrayOfUnknownSize searchInASortedArrayOfUnknownSize = new SearchInASortedArrayOfUnknownSize();
        int target = 12;
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(searchInASortedArrayOfUnknownSize.search(index -> index >= nums.length ? Integer.MAX_VALUE : nums[index], target));
    }

    private int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = reader.get(mid);

            if (midValue == target) return mid;
            else if (midValue > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}

