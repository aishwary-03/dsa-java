package com.dsa.patterns.revisit.second;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().longest("pwwkew"));
    }

    private int longest(String s) {
        int start = 0;
        int end = 0;
        int longest = 0;
        Map<Character, Integer> characterToIndex = new HashMap<>();

        while (end < s.length()) {
            char curr = s.charAt(end);
            if (characterToIndex.containsKey(curr) && characterToIndex.get(curr) >= start) {
                longest = Math.max(end - start, longest);
                start = characterToIndex.get(curr) + 1;
            }
            characterToIndex.put(curr, end);
            end++;
        }
        return Math.max(longest, end - start);
    }



}
