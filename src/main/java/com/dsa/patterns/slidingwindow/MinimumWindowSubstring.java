package com.dsa.patterns.slidingwindow;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("BaaaAba", "Aa"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] frequencyMap = new int[128];
        for (int i = 0; i < t.length(); i++) {
            frequencyMap[t.charAt(i)]++;
        }

        int matchCount = 128;
        for (int i = 0; i < 128; i++) {
            if (frequencyMap[i] > 0) matchCount--;
        }

        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        String minSubString = "";

        while (end < s.length()) {
            char c = s.charAt(end);
            frequencyMap[c]--;
            if (frequencyMap[c] == 0) matchCount++;
            while (matchCount == 128) {
                if (minWindow > end - start + 1) {
                    minWindow = end - start + 1;
                    minSubString = s.substring(start, end + 1);
                }
                frequencyMap[s.charAt(start)]++;
                if (frequencyMap[s.charAt(start)] > 0) matchCount--;
                start++;
            }
            end++;
        }
        return minSubString;
    }

}
