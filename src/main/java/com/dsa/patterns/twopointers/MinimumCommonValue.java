package com.dsa.patterns.twopointers;

public class MinimumCommonValue {

    public static void main(String[] args) {
        MinimumCommonValue minimumCommonValue = new MinimumCommonValue();
        System.out.println(minimumCommonValue.getCommon(new int[]{1}, new int[]{2}));
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

}
