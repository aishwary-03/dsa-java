package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        TreeNode.printTree(root);

        System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }

}
