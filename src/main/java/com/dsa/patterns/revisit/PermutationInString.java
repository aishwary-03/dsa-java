package com.dsa.patterns.revisit;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaoooo";
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freqMap = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freqMap[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);

            freqMap[c-'a']--;

            if (right - left + 1 > s1.length()) {
                freqMap[s2.charAt(left) - 'a']++;
                left++;
            }

            if (right - left + 1 == s1.length()) {
                boolean found = true;
                for (int count : freqMap) {
                    if (count != 0) {
                        found = false;
                        break;
                    }
                }
                if (found) return true;
            }
            right++;
        }
        return false;
    }

}
