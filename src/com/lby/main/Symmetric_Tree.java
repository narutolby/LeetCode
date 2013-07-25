package com.lby.main;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following is not:

 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
public class Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left,root.right);
	}
	public boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left != null && right != null){
			if(left.val == right.val){
              boolean checkedLeft = isSymmetric(left.left,right.right);
              if(!checkedLeft){
            	 return false;
              }else{
            	  boolean checkedRight= isSymmetric(left.right,right.left);
            	  if(checkedRight){
            		  return true;
            	  }else{
            		  return false;
            	  }
              }
			}else{
				return false;
			}
		}else if(left == null && right == null){
			return  true;
		}else{
			return  false;
		}
	}
}
