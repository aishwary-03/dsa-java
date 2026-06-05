package com.dsa.patterns.revisit;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    private int[] maxWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);

        for (int end = 0; end < nums.length; end++) {
            pq.offer(end);
            if (pq.size() >= k) {
                while (!pq.isEmpty() && pq.peek() <= end - k) {
                    pq.poll();
                }
                result[end - k + 1] = nums[pq.peek()];
            }
        }
        return result;
    }

}
