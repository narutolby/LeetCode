package com.lby.main;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Validate_Binary_Search_Tree {
	public boolean isValidBST(TreeNode root) {
		int left = Integer.MIN_VALUE,right = Integer.MAX_VALUE;
		return isValidBST(root,left,right);
	}
	public boolean isValidBST(TreeNode root,int left,int right) {
		if (root == null) {
			return true;
		}
		boolean checkLeft = isValidBST(root.left,left,root.val);
		if (!checkLeft) {
			return false;
		}
		boolean checkRight = isValidBST(root.right,root.val,right);
		if (!checkRight) {
			return false;
		}
		if(root.val <= left || root.val >= right){
			return false;
		}
		if ((root.left == null && root.right == null)
				|| (root.left == null && root.right != null && root.right.val > root.val)
				|| (root.right == null && root.left != null && root.left.val < root.val)
				|| (root.left != null && root.right != null
						&& root.left.val < root.val && root.right.val > root.val)) {
			return true;
		} else {
			return false;
		}
	}
}
