package com.dsa.patterns.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(wordSearchII.findWords(board, words));
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) insert(root, w);

        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(char[][] board, int startRow, int startCol, TrieNode node, List<String> result) {
        if (startRow < 0 || startRow >= board.length || startCol < 0 || startCol >= board[0].length) return;

        char c = board[startRow][startCol];
        if (c == '#') return;

        TrieNode next = node.children[c - 'a'];

        if (next == null) return;

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[startRow][startCol] = '#';
        for (int[] direction : directions) {
            dfs(board, startRow + direction[0], startCol + direction[1], next, result);
        }

        board[startRow][startCol] = c;
        if (isLeaf(next)) node.children[c - 'a'] = null;
    }

    private boolean isLeaf(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null) return false;
        return true;
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.word = word;
    }
}
