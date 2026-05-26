package com.dsa.patterns.heaps;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {

    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) maxHeap.offer(f);
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldownQueue.offer(new int[]{remaining, time + n + 1});
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time + 1) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }

    public int leastIntervalWithFormula(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) maxFreqCount++;
        }

        int formulaResult = (maxFreq - 1) * (n + 1) + maxFreqCount;

        return Math.max(tasks.length, formulaResult);

    }


}
