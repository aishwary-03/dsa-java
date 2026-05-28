package com.dsa.patterns.dailyquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSuffixQueries {

    public static void main(String[] args) {
        LongestCommonSuffixQueries longestCommonSuffixQueries = new LongestCommonSuffixQueries();
        String[] wordsContainer = {"abcdefgh","poiuygh","ghghgh"};
        String[] wordsQuery = {"gh","acbfgh","acbfegh"};
        System.out.println(Arrays.toString(longestCommonSuffixQueries.stringIndices(wordsContainer, wordsQuery)));
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] result = new int[wordsQuery.length];
        Arrays.fill(result, -1);

        Map<String, Integer> suffixToWordIndex = new HashMap<>();

        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            for (int j = 0; j < word.length(); j++) {
                String suffix = word.substring(j);
                if (suffixToWordIndex.containsKey(suffix)) {
                    String smallestWord = wordsContainer[suffixToWordIndex.get(suffix)];
                    if (smallestWord.length() > word.length()) {
                        suffixToWordIndex.put(suffix, i);
                    }
                } else {
                    suffixToWordIndex.put(suffix, i);
                }
            }
            suffixToWordIndex.putIfAbsent("", i);
            if (wordsContainer[suffixToWordIndex.get("")].length() > word.length()) {
                suffixToWordIndex.put("", i);
            }
        }

        for (int i = 0; i < wordsQuery.length; i++) {
            String word = wordsQuery[i];
            for (int j = 0; j < word.length(); j++) {
                String suffix = word.substring(j);
                if (suffixToWordIndex.containsKey(suffix)) {
                    result[i] = suffixToWordIndex.get(suffix);
                    break;
                }
            }
            if (result[i] == -1) {
                result[i] = suffixToWordIndex.get("");
            }
        }


        return result;
    }

}
