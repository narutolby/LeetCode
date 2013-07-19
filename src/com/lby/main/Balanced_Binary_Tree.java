package com.lby.main;

/*
 *Given a binary tree, determine if it is height-balanced.
 *For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Balanced_Binary_Tree {
	public static boolean isBalanced(TreeNode root) {
		int depth = depthOfTree(root, null);
		if (depth == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static int depthOfTree(TreeNode root, Integer depth) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int leftPath = depthOfTree(root.left, null);
		if (leftPath == -1) {
			return -1;
		}
		if (depth != null && leftPath - depth > 1) {
			return -1;
		}
		int rightPath = depthOfTree(root.right, leftPath);
		if (rightPath == -1 || Math.abs(rightPath - leftPath) > 1) {
			return -1;
		} else {
			return Math.max(leftPath, rightPath) + 1;
		}
	}

}
