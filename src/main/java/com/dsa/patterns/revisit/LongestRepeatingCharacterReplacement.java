package com.dsa.patterns.revisit;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABCBBA", 2));
    }

    public int characterReplacement(String s, int k) {
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;
        int start = 0;
        int end = 0;
        int longest = 0;

        while (end < s.length()) {
            int freq = frequencyMap[s.charAt(end) - 'A'];
            freq++;
            maxFrequency = Math.max(maxFrequency, freq);
            while ((end - start + 1) - maxFrequency > k) {
                longest = Math.max(longest, end - start);
                frequencyMap[s.charAt(start) - 'A']--;
                start++;
            }
            end++;
        }
        return Math.max(longest, end - start);
    }

}
