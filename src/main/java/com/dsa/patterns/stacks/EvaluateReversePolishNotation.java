package com.dsa.patterns.stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"0", "4", "/"}));
    }

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());

                int result = switch (token) {
                    case "+" -> first + second;
                    case "*" -> first * second;
                    case "-" -> first - second;
                    case "/" -> first / second;
                    default -> 0;
                };
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }

}
