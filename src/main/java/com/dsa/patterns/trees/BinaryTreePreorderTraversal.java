package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        TreeNode.printTree(root);

        System.out.println(binaryTreePreorderTraversal.preorderTraversal(root));

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return result;

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
    }

}
