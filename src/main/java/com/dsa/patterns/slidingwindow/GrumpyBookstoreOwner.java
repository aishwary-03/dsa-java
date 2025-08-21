package com.dsa.patterns.slidingwindow;

public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        GrumpyBookstoreOwner grumpyBookstoreOwner = new GrumpyBookstoreOwner();
        int maxSatisfied = grumpyBookstoreOwner.maxSatisfied(new int[]{1}, new int[]{0}, 1);
        System.out.println(maxSatisfied);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int minHappyCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                minHappyCustomers += customers[i];
            }
        }
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                minHappyCustomers += customers[i];
            }
        }
        int maxHappyCustomers = minHappyCustomers;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                minHappyCustomers += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                minHappyCustomers -= customers[i - minutes];
            }
            maxHappyCustomers = Math.max(maxHappyCustomers, minHappyCustomers);
        }
        return maxHappyCustomers;
    }

}
