package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        TreeNode.printTree(root);

        System.out.println(binaryTreePostorderTraversal.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return result;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);

        return result;
    }

}
