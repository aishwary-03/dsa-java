package com.dsa.patterns.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {

            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {

                int[] top = stack.pop();

                int index = top[0];
                int height = top[1];

                maxArea = Math.max(maxArea, height * (i - index));

                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {

            int[] top = stack.pop();

            int index = top[0];
            int height = top[1];

            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }


}
