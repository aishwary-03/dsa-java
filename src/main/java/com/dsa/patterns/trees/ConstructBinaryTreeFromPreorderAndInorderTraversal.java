package com.dsa.patterns.trees;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    Map<Integer, Integer> inorderToIndex = new HashMap<>();
    int preOrderIndex;

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        printTree((constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder)));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderToIndex.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inorderToIndex.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderToIndex.get(rootValue) + 1, right);

        return root;
    }

    public static void printTree(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            result.add(current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        System.out.println(result);
    }

}
