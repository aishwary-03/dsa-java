package com.dsa.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        boolean isValid = containsDuplicateII.containsNearbyDuplicate(new int[]{0, 1, 2, 3, 2, 5}, 3);
        System.out.println(isValid);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToInex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueToInex.containsKey(nums[i]) && i - valueToInex.get(nums[i]) <= k) {
                return true;
            }
            valueToInex.put(nums[i], i);
        }

        return false;
    }

}
