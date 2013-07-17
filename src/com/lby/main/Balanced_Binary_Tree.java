package com.lby.main;

public class Balanced_Binary_Tree {
	public static boolean isBalanced(TreeNode root) {
		int depth = depthOfTree(root);
		if (depth == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static int depthOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int leftPath = depthOfTree(root.left);
		if (leftPath == -1) {
			return -1;
		}
		int rightPath = depthOfTree(root.right);
		if (rightPath == -1 || Math.abs(rightPath - leftPath) > 1) {
			return -1;
		} else {
			return Math.max(leftPath, rightPath) + 1;
		}
	}

}
