package com.lby.main;

public class Maximum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if(root.left==null && root.right==null){
			return 1;
		}
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		if(leftDepth==0){
			leftDepth = Integer.MAX_VALUE;
		}
		if(rightDepth == 0){
			rightDepth = Integer.MAX_VALUE;
		}
		return 1+Math.min(leftDepth,rightDepth );
	}
}
