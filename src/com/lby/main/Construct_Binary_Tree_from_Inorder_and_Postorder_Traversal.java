package com.lby.main;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author narutolby
 * 
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len = inorder.length;
		if(len==0){
			return null;
		}
		return buildTree(inorder, 0, len - 1, postorder,0,len-1);
	}

	public TreeNode buildTree(int[] inorder, int s1, int e1, int[] postorder,int s2,int e2) {
		    if(s1>e1){
		    	return null;
		    }
            int rootVal = postorder[e2];
            TreeNode root = new TreeNode(rootVal);
            int rootLeft = s1;
            while(inorder[rootLeft]!=rootVal){
            	rootLeft++;
            }
            root.left = buildTree(inorder,s1,rootLeft-1,postorder,s2,s2+rootLeft-s1-1);
            root.right= buildTree(inorder,rootLeft+1,e1,postorder,s2+rootLeft-s1,e2-1);
            
            return root; 
	}
}
