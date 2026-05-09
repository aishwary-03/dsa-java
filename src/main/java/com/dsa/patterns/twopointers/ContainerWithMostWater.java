package com.dsa.patterns.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] heights = new int[] {1, 1};
        System.out.println(containerWithMostWater.maxArea(heights));
    }

    private int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, tempArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

}
