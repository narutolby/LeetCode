package com.lby.main; 

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
 
public class Binary_Tree_Inorder_Traversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> arry = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null) {
			stack.push(root);
			if (root.left == null) {
				TreeNode tn = stack.pop();
				arry.add(tn.val);
				while (root.right == null) {
					if(stack.size()>=0){
						root = stack.pop();
						arry.add(root.val);
					}else{
						break;
					}
				}
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return arry;
	}
}
