package com.dsa.patterns.dailyquestion;

public class CountTheNumberOfSpecialCharactersII {

    public static void main(String[] args) {
        CountTheNumberOfSpecialCharactersII countTheNumberOfSpecialCharactersII = new CountTheNumberOfSpecialCharactersII();
        String word = "eEb";
        System.out.println(countTheNumberOfSpecialCharactersII.numberOfSpecialChars(word));
    }

    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                if (upper[chars[i] - 'A'] == 0) {
                    upper[chars[i] - 'A'] = i + 1;
                }
            } else {
                lower[chars[i] - 'a'] = i + 1;
            }
        }
        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (upper[i] > 0 && lower[i] > 0 && lower[i] < upper[i]) {
                answer++;
            }
        }
        return answer;
    }

}
