package com.dsa.patterns.revisit;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        System.out.println(kokoEatingBananas.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;

        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }

        int low = 1;
        int high = maxPile;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canAchieve(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canAchieve(int speed, int[] piles, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours <= h;
    }
}
