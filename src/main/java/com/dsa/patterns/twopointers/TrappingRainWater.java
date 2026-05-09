package com.dsa.patterns.twopointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = new int[]{5, 2, 3, 0, 2, 4};
        System.out.println(trappingRainWater.totalWater(height));
    }

    private int totalWater(int[] height) {
        int totalWater = 0;

        int left = 0;
        int leftMax = 0;
        int rightMax = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

}
