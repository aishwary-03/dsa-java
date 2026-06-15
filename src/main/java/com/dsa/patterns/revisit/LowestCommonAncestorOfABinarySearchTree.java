package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        TreeNode commonAncestor = lowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, root, root.left);
        System.out.println(commonAncestor.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
