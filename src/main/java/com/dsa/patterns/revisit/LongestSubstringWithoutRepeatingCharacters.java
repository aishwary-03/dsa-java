package com.dsa.patterns.revisit;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "";
        System.out.println(longestSubstringWithoutRepeatingCharacters.longestSubstring(s));
    }

    private int longestSubstring(String s) {
        int longest = 0;

        Map<Character, Integer> characterToLastIndex = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (characterToLastIndex.containsKey(s.charAt(right)) && characterToLastIndex.get(s.charAt(right)) >= left) {
                longest = Math.max(right - left, longest);
                left = characterToLastIndex.get(s.charAt(right)) + 1;
            }
            characterToLastIndex.put(s.charAt(right), right);
            right++;

        }
        return Math.max(longest, right - left);
    }

}
