package com.dsa.patterns.hashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = new String[] {""};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> frequencyToAnagrams = new HashMap<>();

        for (String str : strs) {
            int[] chars = new int[26];
            for (int j = 0; j < str.length(); j++) {
                chars[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int c : chars) {
                sb.append(c);
                sb.append("#");
            }
            frequencyToAnagrams.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(frequencyToAnagrams.values());
    }

}
