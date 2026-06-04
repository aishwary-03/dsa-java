package com.dsa.patterns.revisit.second;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("aa", "bb"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] frequencyMap = new int[26];
        for (char c : s1.toCharArray()) {
            frequencyMap[c - 'a']++;
        }

        int start = 0;
        int end = 0;

        while (end < s2.length()) {
            char c = s2.charAt(end);
            frequencyMap[c - 'a']--;
            if (end - start + 1 > s1.length()) {
                frequencyMap[s2.charAt(start) - 'a']++;
                start++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (frequencyMap[i] == 0) count++;
            }
            if (count == 26) return true;
            end++;
        }
        return false;
    }

}
