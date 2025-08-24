package com.dsa.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        List<Integer> anagrams = findAllAnagramsInAString.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa");
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        if (p.length() > s.length()) return indexes;

        int[] pCharacterToIndex = new int[26];
        int[] sCharacterToIndex = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCharacterToIndex[p.charAt(i) - 'a'] += 1;
            sCharacterToIndex[s.charAt(i) - 'a'] += 1;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (sCharacterToIndex[i] == pCharacterToIndex[i]) matches++;
        }

        if (matches == 26) indexes.add(0);

        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            int prevChar = s.charAt(i - 1) - 'a';
            int currChar = s.charAt(i + p.length() - 1) - 'a';

            sCharacterToIndex[currChar] += 1;
            if (sCharacterToIndex[currChar] == pCharacterToIndex[currChar]) {
                matches++;
            } else if (sCharacterToIndex[currChar] - 1 == pCharacterToIndex[currChar]) {
                matches--;
            }
            sCharacterToIndex[prevChar] -= 1;
            if (sCharacterToIndex[prevChar] == pCharacterToIndex[prevChar]) {
                matches++;
            } else if (sCharacterToIndex[prevChar] + 1 == pCharacterToIndex[prevChar]) {
                matches--;
            }
            if (matches == 26) indexes.add(i);
        }
        return indexes;

    }

}
