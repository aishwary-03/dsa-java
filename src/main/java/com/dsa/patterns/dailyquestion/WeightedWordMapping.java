package com.dsa.patterns.dailyquestion;

public class WeightedWordMapping {

    public static void main(String[] args) {
        WeightedWordMapping weightedWordMapping = new WeightedWordMapping();
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        System.out.println(weightedWordMapping.mapWordWeights(words, weights));
    }

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (char c : word.toCharArray()) {
                weight += weights[c - 'a'];
            }
            sb.append((char)('z' - weight % 26));
        }
        return sb.toString();
    }
}
