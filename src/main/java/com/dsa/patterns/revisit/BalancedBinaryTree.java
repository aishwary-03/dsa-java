package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class BalancedBinaryTree {

    private static final int UNBALANCED_HEIGHT = -1;

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(balancedBinaryTree.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != UNBALANCED_HEIGHT;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == UNBALANCED_HEIGHT) return UNBALANCED_HEIGHT;

        int right = height(node.right);
        if (right == UNBALANCED_HEIGHT) return UNBALANCED_HEIGHT;

        if (Math.abs(left - right) > 1) return UNBALANCED_HEIGHT;

        return 1 + Math.max(left, right);
    }
}
