package com.dsa.patterns.hashing;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> numberToFrequency = new HashMap<>();
        for (int num : nums) {
            numberToFrequency.merge(num, 1, Integer::sum);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        numberToFrequency.forEach((number, frequency) -> {
            minHeap.offer(new int[] {number, frequency});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll()[0];
        }
        return result;
    }
}

