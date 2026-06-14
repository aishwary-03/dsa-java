package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths.binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> path, List<String> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(buildPath(path));
        }

        dfs(node.left, path, result);
        dfs(node.right, path, result);

        path.removeLast();
    }

    private String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append("->");
            sb.append(path.get(i));
        }
        return sb.toString();
    }
}
