package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {0};
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int left = height(node.left, diameter);
        int right = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    }
}
