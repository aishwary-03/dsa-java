package com.dsa.patterns.dailyquestion;

import com.dsa.patterns.trees.TreeNode;

import java.util.*;

public class CreateBinaryTreeFromDescriptions {

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions createBinaryTreeFromDescriptions = new CreateBinaryTreeFromDescriptions();
        int[][] descriptions = {
                {85, 82, 1},
                {74, 85, 1},
                {39, 70, 0},
                {82, 38, 1},
                {74, 39, 0},
                {39, 13, 1}
        };
        TreeNode root = createBinaryTreeFromDescriptions.createBinaryTree(descriptions);
        printTree(root);

    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            map.putIfAbsent(description[0], new TreeNode(description[0]));
            map.putIfAbsent(description[1], new TreeNode(description[1]));

            TreeNode node =  map.get(description[0]);
            TreeNode child = map.get(description[1]);

            if (description[2] == 1) {
               node.left = child;
            } else {
                node.right = child;
            }

            children.add(description[1]);
        }

        for (TreeNode node : map.values()) {
            if (!children.contains(node.val)) {
                return node;
            }
        }

        return null;
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
