package com.dsa.patterns.dailyquestion;

public class CountTheNumberOfSpecialCharactersI {

    public static void main(String[] args) {
        CountTheNumberOfSpecialCharactersI countTheNumberOfSpecialCharactersI = new CountTheNumberOfSpecialCharactersI();
        String word = "abBCab";
        System.out.println(countTheNumberOfSpecialCharactersI.numberOfSpecialChars(word));
    }

    public int numberOfSpecialChars(String word) {
        int[] lowerCaseFreqMap = new int[26];
        int[] upperCaseFreqMap = new int[26];

        char[] chars = word.toCharArray();

        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                upperCaseFreqMap[ch - 'A']++;
            } else {
                lowerCaseFreqMap[ch - 'a']++;
            }
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (lowerCaseFreqMap[i] > 0 && upperCaseFreqMap[i] > 0) {
                answer++;
            }
        }
        return answer;
    }

}
