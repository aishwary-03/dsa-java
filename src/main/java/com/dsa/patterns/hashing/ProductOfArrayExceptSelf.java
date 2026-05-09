package com.dsa.patterns.hashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int leftProduct = 1;
        int rightProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct = leftProduct * result[i];
        }

        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return result;
    }

}
