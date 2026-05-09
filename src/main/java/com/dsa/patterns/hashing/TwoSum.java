package com.dsa.patterns.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numberToIndex.containsKey(target - nums[i])) {
                return new int[]{numberToIndex.get(target - nums[i]), i};
            }
            numberToIndex.put(nums[i], i);
        }
        return new int[]{};
    }

}
