package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root));
        System.out.println(binaryTreeLevelOrderTraversal.levelOrderIterative(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return tree;
        traverse(root, 0);
        return tree;
    }

    private void traverse(TreeNode node, int level) {
        if (tree.size() == level) {
            tree.add(new ArrayList<>());
        }

        tree.get(level).add(node.val);
        if (node.left != null) traverse(node.left, level + 1);
        if (node.right != null) traverse(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            result.add(level);
        }

        return result;
    }


}
