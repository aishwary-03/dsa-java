package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        System.out.println(validateBinarySearchTree.isValidBST(root));
        System.out.println(validateBinarySearchTree.validate(root));
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;

        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }

        return validate(node.left, minValue , node.val) && validate(node.right, node.val, maxValue);
    }

    private boolean validate(TreeNode node) {
        return inorder(node, new Long[]{null});
    }

    private boolean inorder(TreeNode node, Long[] previous) {
        if (node == null) return true;

        if (!inorder(node.left, previous)) return false;

        if (previous[0] != null && node.val <= previous[0]) return false;

        previous[0] = (long) node.val;

        return inorder(node.right, previous);
    }
}
