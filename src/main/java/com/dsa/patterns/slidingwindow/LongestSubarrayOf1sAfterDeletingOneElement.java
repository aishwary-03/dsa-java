package com.dsa.patterns.slidingwindow;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement longestSubarrayOf1sAfterDeletingOneElement = new LongestSubarrayOf1sAfterDeletingOneElement();
        int longestSubarray = longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[]{0, 0, 0, 0});
        System.out.println(longestSubarray);
    }

    public int longestSubarray(int[] nums) {
        int left = 0;
        int lastIndexOfZero = -1;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = lastIndexOfZero + 1;
                lastIndexOfZero = right;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

}
