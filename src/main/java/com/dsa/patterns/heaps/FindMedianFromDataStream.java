package com.dsa.patterns.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (small.isEmpty() || small.peek() <= num) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (!small.isEmpty() && small.size() > large.size()) {
            return small.peek();
        }

        if (!large.isEmpty() && large.size() > small.size()) {
            return large.peek();
        }

        return (large.peek() + small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(1);
        findMedianFromDataStream.addNum(2);
        findMedianFromDataStream.addNum(3);
        System.out.println(findMedianFromDataStream.findMedian());
    }


}
