package com.lby.main;

/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
 */
public class Binary_Tree_Maximum_Path_Sum {
    //这个方法虽然能过，但是不好，重写
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		        max = Integer.MIN_VALUE;
         		maxPathSumTmp(root);
         		return max;
	}
	public int maxPathSumTmp(TreeNode root) {
           if(root.left==null && root.right==null){
        	       if(root.val>max){
        	    	   max = root.val;
        	       }
        		   return root.val;
           }
           int left=Integer.MIN_VALUE,right=Integer.MIN_VALUE;
           if(root.left!=null){
                left = maxPathSumTmp(root.left);
           }
           if(root.right!=null){
        	    right = maxPathSumTmp(root.right);
           }
           left = (root.left==null?0:left);
           right = (root.right==null?0:right);
           int leftMax = root.val+left;
           int rightMax = root.val+right;
           int tmp_max = Math.max(root.val, Math.max(root.val, Math.max(leftMax, rightMax)));
           int sum = root.val+left+right;
           if(tmp_max>max){
        	   max = tmp_max;
           }
           if(sum>max){
        	   max = sum;
           }
           return tmp_max;
	}
    /*****************************************************/

    //第二个方法,Accepted

    int _max = Integer.MIN_VALUE;
    public int _maxPathSum(TreeNode root){
        if(root==null){
            return 0;
        }
       _maxPathSumTmp(root);
       return _max;
    }
    public int _maxPathSumTmp(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax = _maxPathSumTmp(root.left);
        int rightMax = _maxPathSumTmp(root.right);
        leftMax=(leftMax<0)?0:leftMax;
        rightMax=(rightMax<0)?0:rightMax;
        _max = Math.max(root.val+leftMax+rightMax,_max);
        return Math.max(root.val+leftMax,root.val+rightMax);
    }
}
