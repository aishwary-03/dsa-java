package com.dsa.patterns.revisit;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));
    }

    private String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        String minWindow = "";
        int minLength = Integer.MAX_VALUE;

        int[] freqMap = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freqMap[t.charAt(i)]++;
        }

        int required = t.length();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            freqMap[s.charAt(end)]--;
            if (freqMap[s.charAt(end)] >= 0) required--;
            while (required == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minWindow = s.substring(start, end + 1);
                }
                freqMap[s.charAt(start)]++;
                if (freqMap[s.charAt(start)] > 0) required++;
                start++;
            }
        }
        return minWindow;
    }
}
