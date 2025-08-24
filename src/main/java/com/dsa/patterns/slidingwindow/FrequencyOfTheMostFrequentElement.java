package com.dsa.patterns.slidingwindow;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        FrequencyOfTheMostFrequentElement frequencyOfTheMostFrequentElement = new FrequencyOfTheMostFrequentElement();
        int maxFrequency = frequencyOfTheMostFrequentElement.maxFrequency(new int[]{3,9,6}, 2);
        System.out.println(maxFrequency);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long windowSum = 0;
        int maxFrequency = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while ((long)(right - left + 1) * nums[right] - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }

}
