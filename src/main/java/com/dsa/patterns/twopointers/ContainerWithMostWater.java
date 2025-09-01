package com.dsa.patterns.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int maxArea = containerWithMostWater.maxArea(new int[]{1, 1});
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int tempArea = 0;
            if (height[left] < height[right]) {
                tempArea = (right - left) * height[left];
                left++;
            } else {
                tempArea = (right - left) * height[right];
                right--;
            }
            maxArea = Math.max(maxArea, tempArea);
        }
        return maxArea;
    }

}
