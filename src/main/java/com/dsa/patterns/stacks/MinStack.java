package com.dsa.patterns.stacks;

import java.util.*;

public class MinStack {

    Deque<int[]> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public void push(int val) {
        int currMin = Integer.MAX_VALUE;
        if (!stack.isEmpty()) {
            currMin = stack.peek()[1];
        }
        stack.push(new int[]{val, Math.min(currMin, val)});
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek()[0];
        }
        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty()) {
           return stack.peek()[1];
        }
        return -1;
    }
}
