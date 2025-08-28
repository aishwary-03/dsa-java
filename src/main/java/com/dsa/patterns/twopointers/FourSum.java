package com.dsa.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSome {

    public static void main(String[] args) {
        FourSome fourSome = new FourSome();
        List<List<Integer>> quadruplets = fourSome.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(quadruplets);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int a = 0; a < nums.length - 3; a++) {
            int b = a + 1;
            int c = b + 1;
            int d = nums.length - 1;
            while (c < d) {
                int sum = nums[a] + nums[b] + nums[c] + nums[d];
                if (sum == target) {
                    quadruplets.add(List.of(nums[a], nums[b], nums[c], nums[d]));

                    c++;
                    d--;
                } else if (sum < target) {
                    c++;
                } else {
                    d--;
                }
            }
        }
        return quadruplets;
    }
}
