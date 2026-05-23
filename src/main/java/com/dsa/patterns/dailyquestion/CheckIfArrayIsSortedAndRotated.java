package com.dsa.patterns.dailyquestion;

public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated checkIfArrayIsSortedAndRotated = new CheckIfArrayIsSortedAndRotated();
        int[] nums = {10, 1, 1, 10};
        System.out.println(checkIfArrayIsSortedAndRotated.check(nums));
    }

    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }
        return true;

    }

}
