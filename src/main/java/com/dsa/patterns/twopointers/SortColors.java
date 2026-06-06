package com.dsa.patterns.twopointers;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2, 2, 2, 1, 1, 1, 0, 0, 0});
    }

    public void sortColors(int[] nums) {
       int leftIndex = 0;
       int rightIndex = nums.length - 1;
       int current = 0;

       while (current < rightIndex) {
           if (nums[current] == 0) {
               nums[current] = nums[leftIndex];
               nums[leftIndex] = 0;
               current++;
               leftIndex++;
           } else if (nums[current] == 2) {
               nums[current] = nums[rightIndex];
               nums[rightIndex] = 2;
               rightIndex--;
           } else {
               current++;
           }
       }
    }
}
