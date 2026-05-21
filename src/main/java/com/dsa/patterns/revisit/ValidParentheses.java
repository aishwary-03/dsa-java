package com.dsa.patterns.revisit;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("(]"));
    }

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '}') {
                if (!characterStack.isEmpty() && characterStack.peek() == '{') {
                    characterStack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!characterStack.isEmpty() && characterStack.peek() == '[') {
                    characterStack.pop();
                } else {
                    return false;
                }
            } else if (c == ')') {
                if (!characterStack.isEmpty() && characterStack.peek() == '(') {
                    characterStack.pop();
                } else {
                    return false;
                }
            } else {
                characterStack.push(c);
            }
        }
        return characterStack.isEmpty();
    }

}
