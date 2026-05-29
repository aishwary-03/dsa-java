package com.dsa.patterns.dailyquestion;

public class MinimumElementAfterReplacementWithDigitSum {

    public static void main(String[] args) {
        MinimumElementAfterReplacementWithDigitSum minimumElementAfterReplacementWithDigitSum = new MinimumElementAfterReplacementWithDigitSum();
        System.out.println(minimumElementAfterReplacementWithDigitSum.minElement(new int[]{999, 19, 199}));
    }

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            min = Math.min(sum, min);
        }
        return min;
    }

}
