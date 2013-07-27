package com.lby.main;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Recover_Binary_Search_Tree {
	Integer first = null;
	TreeNode t1 = null;
	TreeNode e1 = null, e2 = null;

	public void recoverTree(TreeNode root) {
		first = null;
		t1 = null;
		e1 = null;
		e2 = null;
		inOrder(root);
		int tmp = e1.val;
		e1.val = e2.val;
		e2.val = tmp;
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		if (first != null) {
			if (root.val < first) {
				if (e1 == null) {
					e1 = t1;
				}
				e2 = root;
			}
		}
		first = root.val;
		t1 = root;
		inOrder(root.right);
	}
}
