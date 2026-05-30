package com.dsa.patterns.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, row, col));
                }
            }
        }
        return maxArea;

    }

    private int bfs(int[][] grid, boolean[][] visited, int row, int col) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0
                        && newCol < grid[0].length && grid[newRow][newCol] == 1
                        && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                    area++;
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + dfs(grid, visited, row + 1, col)
                + dfs(grid, visited, row - 1, col)
                + dfs(grid, visited, row, col + 1)
                + dfs(grid, visited, row, col - 1);
    }

}
