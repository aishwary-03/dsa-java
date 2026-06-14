package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode.printTree(root);
        TreeNode inverted = invertBinaryTree.invertTree(root);
        TreeNode.printTree(inverted);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
