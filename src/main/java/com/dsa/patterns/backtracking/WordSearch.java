package com.dsa.patterns.backtracking;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "SEE";
        System.out.println(wordSearch.exist(board, word));
    }


    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(board, word, visited, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (index == word.length()) return true;

        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[0].length) return false;
        if (visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;

        visited[row][col] = true;

        for (int[] dir : directions) {
            if (backtrack(board, word, visited, row + dir[0], col + dir[1], index + 1)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}
