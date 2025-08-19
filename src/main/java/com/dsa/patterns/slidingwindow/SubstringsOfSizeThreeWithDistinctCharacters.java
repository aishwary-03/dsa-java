package com.dsa.patterns.slidingwindow;

public class SubstringsOfSizeThreeWithDistinctCharacters {

    public static void main(String[] args) {
        SubstringsOfSizeThreeWithDistinctCharacters substringsOfSizeThreeWithDistinctCharacters = new SubstringsOfSizeThreeWithDistinctCharacters();
        int goodSubstrings = substringsOfSizeThreeWithDistinctCharacters.countGoodSubstrings("xyzzaz");
        System.out.println(goodSubstrings);
    }

    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i+1) != s.charAt(i+2)) {
                count++;
            }
        }
        return count;
    }
}
