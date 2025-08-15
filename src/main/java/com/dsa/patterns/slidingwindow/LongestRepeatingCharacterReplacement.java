package com.dsa.patterns.slidingwindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int length = longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1);
        System.out.println(length);
    }

    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;
        HashMap<Character, Integer> characterToFrequency = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            int charFrequency = characterToFrequency.getOrDefault(s.charAt(right), 0);
            characterToFrequency.put(s.charAt(right), charFrequency + 1);
            maxFrequency = Math.max(maxFrequency, characterToFrequency.get(s.charAt(right)));
            int windowSize = right - left + 1;
            if (windowSize - maxFrequency > k) {
                characterToFrequency.compute(s.charAt(left),  (key, frequency) -> frequency - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
