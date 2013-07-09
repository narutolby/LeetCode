package com.lby.main;

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
