package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printTree(invertBinaryTree.invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);

        invertTree(root.right);

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
