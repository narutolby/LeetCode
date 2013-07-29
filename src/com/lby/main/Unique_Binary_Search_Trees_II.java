package com.lby.main;

import java.util.ArrayList;

/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? 
 */
public class Unique_Binary_Search_Trees_II {
	 public ArrayList<TreeNode> generateTrees(int n) {
             ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();	        
             ArrayList<ArrayList<TreeNode>> dp = new ArrayList<ArrayList<TreeNode>>();             
             dp.add(null);
             for(int i=1;i<=n;i++){
            	 for(int j=1;j<=i;j++){
//            		 ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            	 }
             }
             return nodeList;
	 }
	 public TreeNode cloneTree(TreeNode node,int step){
		 if(node == null){
			 return null;
		 }
		 TreeNode root = new TreeNode(node.val+step);
		 root.left = cloneTree(node.left,step);
		 root.right = cloneTree(node.right,step);
		 return root;
	 }
}
