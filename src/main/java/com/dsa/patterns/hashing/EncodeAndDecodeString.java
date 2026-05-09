package com.dsa.patterns.hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    public static void main(String[] args) {
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        List<String> strs = List.of("Hello", "World");
        String encoded = encodeAndDecodeString.encode(strs);
        System.out.println(encoded);
        List<String> decoded = encodeAndDecodeString.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + length + 1);
            decoded.add(word);
            i = j + length + 1;
        }

        return decoded;
    }

}
