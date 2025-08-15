package com.dsa.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int length = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> characterToLastVisitedIndex = new HashMap<>();
        while (right < s.length()) {
            if (characterToLastVisitedIndex.containsKey(s.charAt(right)) && characterToLastVisitedIndex.get(s.charAt(right)) >= left) {
                left = characterToLastVisitedIndex.get(s.charAt(right)) + 1;
            }
            characterToLastVisitedIndex.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }



}
