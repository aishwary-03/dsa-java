package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        int[] sortedSquares = squaresOfASortedArray.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(sortedSquares));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

}
