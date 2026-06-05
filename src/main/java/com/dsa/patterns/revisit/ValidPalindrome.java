package com.dsa.patterns.revisit;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isValid("A man, a plan, a canal: Panama"));
    }

    private boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right)) && s.charAt(left) != s.charAt(right)) {
                return false;
            } else if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

}
