package com.dsa.patterns.trees;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(subtreeOfAnotherTree.isSubtree(root, subRoot));
        System.out.println(subtreeOfAnotherTree.isSubtreeOptimal(root, subRoot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSubtreeOptimal(TreeNode root, TreeNode subRoot) {
        String rootString = serialize(root);
        String subRootString = serialize(subRoot);
        return rootString.contains(subRootString);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private String serialize(TreeNode node) {
        if (node == null) return "$";
        return "#" + node.val + "," + serialize(node.left) + "," + serialize(node.right);
    }

}
