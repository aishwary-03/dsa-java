package com.dsa.patterns.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("A", 2));
    }

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int maxFrequency = 0;
        int[] frequency = new int[26];

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            frequency[c - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[c - 'A']);
            if (right - left + 1 - maxFrequency > k) {
                longest = Math.max(longest, right - left);
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return Math.max(longest, right - left);
    }

}
