package com.dsa.patterns.twopointers;

public class RemovePalindromicSubsequences {

    public static void main(String[] args) {
        RemovePalindromicSubsequences removePalindromicSubsequences = new RemovePalindromicSubsequences();
        int count = removePalindromicSubsequences.removePalindromeSub("ababa");
        System.out.println(count);
    }

    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return 2;
            }
        }
        return 1;
    }

}
