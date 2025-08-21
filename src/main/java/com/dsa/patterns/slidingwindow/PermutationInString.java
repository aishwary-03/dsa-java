package com.dsa.patterns.slidingwindow;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        boolean isValid = permutationInString.checkInclusion("abc", "bbbca");
        System.out.println(isValid);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.equals(s2)) return true;
        int[] s1CharArray = new int[26];
        int[] s2CharArray = new int[26];
        int matchCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            s1CharArray[s1.charAt(i) - 'a'] += 1;
            s2CharArray[s2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (s1CharArray[i] == s2CharArray[i]) matchCount++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (matchCount == 26) return true;
            int currCharacter = s2.charAt(i) - 'a';
            int previousCharacter = s2.charAt(i - s1.length()) - 'a';

            s2CharArray[currCharacter]++;
            if (s2CharArray[currCharacter] == s1CharArray[currCharacter]) {
                matchCount++;
            } else if (s2CharArray[currCharacter] - 1 == s1CharArray[currCharacter]) {
                matchCount--;
            }

            s2CharArray[previousCharacter]--;
            if (s2CharArray[previousCharacter] == s1CharArray[previousCharacter]) {
                matchCount++;
            } else if (s2CharArray[previousCharacter] + 1 == s1CharArray[previousCharacter]) {
                matchCount--;
            }
        }
        return matchCount == 26;
    }

}
