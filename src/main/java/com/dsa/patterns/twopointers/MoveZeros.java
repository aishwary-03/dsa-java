package com.dsa.patterns.twopointers;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{0});
    }

    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            int left = 0;
            int right = 1;
            while (right < nums.length) {
                if (nums[left] == 0 && nums[right] != 0) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    left++;
                } else if (nums[left] != 0) {
                    left++;
                }
                right++;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

}
