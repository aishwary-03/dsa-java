package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] indexes = twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(indexes));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        return null;
    }

}
