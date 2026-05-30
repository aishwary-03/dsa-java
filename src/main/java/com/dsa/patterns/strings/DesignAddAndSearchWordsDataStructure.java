package com.dsa.patterns.strings;

public class DesignAddAndSearchWordsDataStructure {

    TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure designAddAndSearchWordsDataStructure = new DesignAddAndSearchWordsDataStructure();
        designAddAndSearchWordsDataStructure.addWord("bad");
        designAddAndSearchWordsDataStructure.addWord("dad");
        designAddAndSearchWordsDataStructure.addWord("mad");

        System.out.println(designAddAndSearchWordsDataStructure.search("bad"));
        System.out.println(designAddAndSearchWordsDataStructure.search("pad"));

        System.out.println(designAddAndSearchWordsDataStructure.search("..d"));
        System.out.println(designAddAndSearchWordsDataStructure.search("b.."));
        System.out.println(designAddAndSearchWordsDataStructure.search("..."));
        System.out.println(designAddAndSearchWordsDataStructure.search("b.d"));
        System.out.println(designAddAndSearchWordsDataStructure.search("x.."));
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;

        char ch = word.charAt(index);

        if (ch == '.') {
            for (TrieNode child : node.children) {

                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        return dfs(word, index + 1, node.children[ch - 'a']);
    }

}
