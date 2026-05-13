package com.dsa.patterns.binarysearch;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        System.out.println(kokoEatingBananas.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = piles[0];

        for (int num : piles) {
            maxPile = Math.max(num, maxPile);
        }

        int left = 1;
        int right = maxPile;

        while (left <= right) {
            int minEatingSpeed = left + (right - left) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + minEatingSpeed - 1) / minEatingSpeed;
            }

            if (hours > h) {
                left = minEatingSpeed + 1;
            } else {
                right = minEatingSpeed - 1;
            }
        }
        return left;
    }
}
