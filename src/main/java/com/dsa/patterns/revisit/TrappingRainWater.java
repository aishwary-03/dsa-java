package com.dsa.patterns.revisit;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trappingRainWater.trapAgain(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private int trap(int[] height) {
        int[] leftHeights = new int[height.length];

        int leftMax = 0;

        for (int i = 0; i < height.length; i++) {
            leftHeights[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }

        int rightMax = 0;
        int totalWater = 0;
        for (int i = height.length - 1; i > -1; i--) {
            if (height[i] < leftHeights[i] && height[i] < rightMax) {
                totalWater += Math.min(leftHeights[i], rightMax) - height[i];
            }
            rightMax = Math.max(rightMax, height[i]);
        }
        return totalWater;
    }

    private int trapAgain(int[] height) {
        int totalWater = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        return totalWater;
    }

}
