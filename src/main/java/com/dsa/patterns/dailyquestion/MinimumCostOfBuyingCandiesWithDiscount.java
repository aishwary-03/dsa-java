package com.dsa.patterns.dailyquestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public static void main(String[] args) {
        MinimumCostOfBuyingCandiesWithDiscount minimumCostOfBuyingCandiesWithDiscount = new MinimumCostOfBuyingCandiesWithDiscount();
        System.out.println(minimumCostOfBuyingCandiesWithDiscount.minimumCost(new int[]{6, 5, 7, 9, 2, 2}));
        System.out.println(minimumCostOfBuyingCandiesWithDiscount.minimumCostWithHeaps(new int[]{6, 5, 7, 9, 2, 2}));
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;

        for (int i = cost.length - 1; i > -1; i--) {
            if ((cost.length - 1 - i) % 3 != 2) {
                totalCost = totalCost + cost[i];
            }
        }

        return totalCost;

    }

    public int minimumCostWithHeaps(int[] cost) {
        int totalCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : cost) {
            pq.offer(j);
        }

        int count = 1;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (count % 3 != 0) {
                totalCost += curr;
            }
            count++;
        }
        return totalCost;
    }
}
