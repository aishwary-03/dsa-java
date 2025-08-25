package com.dsa.patterns.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] maxSlidingWindow = slidingWindowMaximum.maxSlidingWindow(new int[]{1}, 1);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[queue.peek()];
            }
        }
        return r;
    }


}
