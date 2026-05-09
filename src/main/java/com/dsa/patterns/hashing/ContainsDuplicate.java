package com.dsa.patterns.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numberToIndex.containsKey(nums[i])) {
                return true;
            }
            numberToIndex.put(nums[i], i);
        }

        return false;
    }


}
