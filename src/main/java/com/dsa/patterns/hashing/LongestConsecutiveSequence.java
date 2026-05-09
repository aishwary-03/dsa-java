package com.dsa.patterns.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = new int[]{1, 0, 1, 2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        for (Integer num : uniqueNumbers) {
            if (!uniqueNumbers.contains(num - 1)) {
                int count = 1;
                int tempNum = num + 1;

                while (uniqueNumbers.contains(tempNum)) {
                    count++;
                    tempNum++;
                }
                longestSequence = Math.max(count, longestSequence);
            }
        }
        return longestSequence;
    }

}
