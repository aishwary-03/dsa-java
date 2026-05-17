package com.dsa.patterns.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{90, 90, 90})));
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperaturesWithoutStack(new int[]{90, 90, 90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return answer;
    }

    public int[] dailyTemperaturesWithoutStack(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int hottest = 0;

        for (int currDay = temperatures.length - 1; currDay > -1; currDay--) {
            int temp = temperatures[currDay];
            if (temp >= hottest) {
                hottest = temp;
                continue;
            }

            int days = 1;
            while (temperatures[currDay + days] <= temp) {
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }
        return answer;

    }

}
