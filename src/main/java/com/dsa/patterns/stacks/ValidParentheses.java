package com.dsa.patterns.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("]"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();

    }

}
