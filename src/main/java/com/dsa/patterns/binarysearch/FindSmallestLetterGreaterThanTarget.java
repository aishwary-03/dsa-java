package com.dsa.patterns.binarysearch;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget fIndSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        System.out.println(fIndSmallestLetterGreaterThanTarget.nextGreatestLetter(new char[]{'c', 'f', 'g'}, 'g'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return letters[low] > target ? letters[low] : letters[0];
    }

}
