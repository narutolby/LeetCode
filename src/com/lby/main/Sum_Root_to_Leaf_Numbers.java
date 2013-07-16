package com.lby.main;
/*
 *Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *Find the total sum of all root-to-leaf numbers.
 *For example,
 *   1
   / \
  2   3
 */
public class Sum_Root_to_Leaf_Numbers {
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		sum=0;
		if (root == null) {
			return 0;
		}
		sum(root, 0);
		return sum;
	}

	public void sum(TreeNode root, int index) {
      if(root==null){
    	  return;
      }
      index*=10;
      index+=root.val;
      if(root.left==null && root.right==null){
    	  sum+=index;
    	  return;
      }
      sum(root.left,index);
      sum(root.right,index);
	}
}
