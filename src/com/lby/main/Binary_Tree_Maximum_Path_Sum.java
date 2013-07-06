package com.lby.main;

public class Binary_Tree_Maximum_Path_Sum {
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
           int sum = left + right + root.val;
           int tmp_max = Math.max(root.val, Math.max(sum, Math.max(leftMax, rightMax)));
           if(tmp_max>max){
        	   max = tmp_max;
           }
           return tmp_max;
	}

	public static void main(String[] args) {
      System.out.println(Integer.MIN_VALUE)           ;
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
