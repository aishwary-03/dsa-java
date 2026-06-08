package com.dsa.patterns.revisit;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement longestSubarrayOf1sAfterDeletingOneElement = new LongestSubarrayOf1sAfterDeletingOneElement();
        System.out.println(longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[]{1}));
    }

    public int longestSubarray(int[] nums) {
        int longest = 0;

        int start = 0;
        int lastIndexOfZero = -1;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                start = lastIndexOfZero + 1;
                lastIndexOfZero = end;
            }
            longest = Math.max(longest, end - start);
        }
        return longest;
    }

}
