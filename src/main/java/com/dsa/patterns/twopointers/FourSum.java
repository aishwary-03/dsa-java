package com.dsa.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> quadruplets = fourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        System.out.println(quadruplets);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long sum = (long)nums[a] + (long)nums[b] + (long)nums[c] + (long)nums[d];
                    if (sum == target) {
                        quadruplets.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;

                        c++;
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }

        }
        return quadruplets;
    }
}
