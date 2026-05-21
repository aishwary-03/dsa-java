package com.dsa.patterns.revisit;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0;  i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return result;
    }


}
