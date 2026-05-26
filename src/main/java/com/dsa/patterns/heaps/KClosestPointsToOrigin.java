package com.dsa.patterns.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] points = {{1,3}, {-2, 2}};
        System.out.println(Arrays.deepToString(kClosestPointsToOrigin.kClosest(points, 1)));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> elements = new PriorityQueue<>((a, b) -> {
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(d2, d1);
        });

        for (int[] point : points) {
            elements.offer(point);
            if (elements.size() > k) {
                elements.poll();
            }
        }
        return elements.toArray(new int[elements.size()][]);
    }


}
