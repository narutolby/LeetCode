package com.lby.main;
/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * @author narutolby
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
             int len = preorder.length;
             if(len==0){
            	 return null;
             }
             return buildTree(preorder,0,len-1,inorder,0,len-1) ;
	    }
	 public TreeNode buildTree(int []preorder,int s1,int e1,int[]inorder,int s2,int e2){
           if(s1>e1){
        	   return null;
           }
           int rootVal = preorder[s1];
           TreeNode root = new TreeNode(rootVal);
           int rootLeft = s2;
           while(inorder[rootLeft]!=rootVal){
        	   rootLeft++;
           }
           root.left = buildTree(preorder,s1+1,s1+rootLeft-s2,inorder,s2,rootLeft-1);
           root.right= buildTree(preorder,s1+rootLeft-s2+1,e1,inorder,rootLeft+1,e2);
           return root ;
           
	 }
}
