package com.dsa.patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class KthSmallestElementInABST {

    public static void main(String[] args) {
        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);

        System.out.println(kthSmallestElementInABST.kthSmallest(root, 2));

    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);

        return arr;
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

}
