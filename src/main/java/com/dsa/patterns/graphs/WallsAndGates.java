package com.dsa.patterns.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public static void main(String[] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null) return;

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || rooms[nr][nc] != 2147483647) {
                    continue;
                }

                rooms[nr][nc] = rooms[row][col] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }
    }
}

