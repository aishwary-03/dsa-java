package com.dsa.patterns.binarysearch;

public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallestElementInASortedMatrix.kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[rows - 1][cols - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (countElementsSmallerThanMid(mid, matrix) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int countElementsSmallerThanMid(int mid, int[][] matrix) {
        int count = 0;

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

}
