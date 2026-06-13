package com.dsa.patterns.binarysearch;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchA2DMatrix.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = matrix[mid / cols][mid % cols];

            if (val == target) return true;

            if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
