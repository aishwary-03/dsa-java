package com.dsa.patterns.slidingwindow;

public class FruitIntoBasket {

    public static void main(String[] args) {
        FruitIntoBasket fruitIntoBasket = new FruitIntoBasket();
        System.out.println(fruitIntoBasket.totalFruit(new int[]{1, 1, 1, 1, 1}));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;

        int start = 0;
        int end = 0;

        int[] basket1 = {-1, 0};
        int[] basket2 = {-1, 0};
        int maxFruits = Integer.MIN_VALUE;

        while (end < fruits.length) {
            if (basket1[0] == -1 || basket1[0] == fruits[end]) {
                basket1[0] = fruits[end];
                basket1[1] = basket1[1] + 1;
            } else if (basket2[0] == -1 || basket2[0] == fruits[end]) {
                basket2[0] = fruits[end];
                basket2[1] = basket2[1] + 1;
            } else {
                maxFruits = Math.max(end - start, maxFruits);
                while (basket1[1] > 0 && basket2[1] > 0) {
                    if (fruits[start] == basket1[0]) {
                        basket1[1]--;
                    } else {
                        basket2[1]--;
                    }
                    start++;
                }
                if (basket1[1] == 0) {
                    basket1[0] = fruits[end];
                    basket1[1] = basket1[1] + 1;
                } else {
                    basket2[0] = fruits[end];
                    basket2[1] = basket2[1] + 1;
                }
            }
            end++;
        }
        return Math.max(maxFruits, end - start);
    }

}
