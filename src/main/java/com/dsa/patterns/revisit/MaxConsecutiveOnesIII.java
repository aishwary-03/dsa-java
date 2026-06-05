package com.dsa.patterns.revisit;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{0}, 2));
    }

    public int longestOnes(int[] nums, int k) {
        int longest = 0;

        int start = 0;
        int end = 0;
        int zeroCount = 0;

        while (end < nums.length) {
            if (nums[end] == 0) zeroCount++;
            longest = Math.max(longest, end - start);
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            end++;
        }
        return Math.max(longest, end - start);
    }

}
