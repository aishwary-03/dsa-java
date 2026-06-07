package com.dsa.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        int count = 0;
        prefixSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.merge(sum, 1, Integer::sum);
        }
        return count;

    }
}
