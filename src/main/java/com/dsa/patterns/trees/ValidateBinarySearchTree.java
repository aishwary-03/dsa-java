package com.dsa.patterns.trees;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(validateBinarySearchTree.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

}
