package com.dsa.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.longestSubstring("abba"));
    }

    private int longestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int longest = 0;

        Map<Character, Integer> characterToLastIndex = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (characterToLastIndex.containsKey(s.charAt(right)) && characterToLastIndex.get(s.charAt(right)) >= left) {
                int length = right - left;
                left = characterToLastIndex.get(s.charAt(right)) + 1;
                longest = Math.max(length, longest);
            }
            characterToLastIndex.put(s.charAt(right), right);
            right++;
        }
        return Math.max(longest, right - left);
    }

}
