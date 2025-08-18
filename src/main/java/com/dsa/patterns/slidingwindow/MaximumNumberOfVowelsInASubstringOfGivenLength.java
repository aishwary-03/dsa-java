package com.dsa.patterns.slidingwindow;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength maximumNumberOfVowelsInASubstringOfGivenLength = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        int maxVowels = maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("leetcode", 3);
        System.out.println(maxVowels);
    }

    public int maxVowels(String s, int k) {
        int tempCount = 0;
        for (int i = 0; i < k; i++) {
            if (isAVowel(s.charAt(i))) tempCount++;
        }
        int maxCount = tempCount;
        for (int i = k; i < s.length(); i++) {
            if (isAVowel(s.charAt(i))) {
                tempCount++;
            }

            if (isAVowel(s.charAt(i - k))) {
                tempCount--;
            }
            maxCount = Math.max(maxCount, tempCount);
        }
        return maxCount;
    }

    private boolean isAVowel(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
    }

}
