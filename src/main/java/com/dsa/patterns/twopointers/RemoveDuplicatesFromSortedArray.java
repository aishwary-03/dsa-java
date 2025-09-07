package com.dsa.patterns.twopointers;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int removedDuplicates = removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(removedDuplicates);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }

}
