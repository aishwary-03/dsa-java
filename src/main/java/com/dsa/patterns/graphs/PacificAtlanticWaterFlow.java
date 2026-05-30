package com.dsa.patterns.graphs;

import java.util.*;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(pacificAtlanticWaterFlow.pacificAtlantic(heights));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            pacificQueue.offer(new int[]{r, 0});
            pacific[r][0] = true;

            atlanticQueue.offer(new int[]{r, cols - 1});
            atlantic[r][cols - 1] = true;
        }

        for (int c = 0; c < cols; c++) {
            pacificQueue.offer(new int[]{0, c});
            pacific[0][c] = true;

            atlanticQueue.offer(new int[]{rows - 1, c});
            atlantic[rows - 1][c] = true;
        }

        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;

    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                        && !visited[nr][nc]
                        && heights[nr][nc] >= heights[r][c]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }
}
