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
        boolean isDeleted = false;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0 && isDeleted) {
                maxLength = Math.max(maxLength, right - left - 1);
                left = lastIndexOfZero + 1;
                lastIndexOfZero = right;
            } else if (nums[right] == 0) {
                lastIndexOfZero = right;
                isDeleted = true;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

}
