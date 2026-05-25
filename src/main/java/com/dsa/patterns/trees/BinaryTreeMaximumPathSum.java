package com.dsa.patterns.trees;

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        gainFromSubtree(root);
        return maxSum;
    }

    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        int localSum = gainFromLeft + root.val + gainFromRight;
        maxSum = Math.max(maxSum, localSum);

       return Math.max(gainFromLeft, gainFromRight) + root.val;

    }


}
