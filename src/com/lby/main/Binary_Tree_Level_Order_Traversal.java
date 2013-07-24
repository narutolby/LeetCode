package com.lby.main;

import java.util.ArrayList;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Binary_Tree_Level_Order_Traversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> rootList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		if(root!=null){
			nodeList.add(root);
			intList.add(root.val);
			rootList.add(intList);
		}
		for(int i=0;i<rootList.size();i++){
           ArrayList<TreeNode> tmpNodeList = new ArrayList<TreeNode>();
           ArrayList<Integer> tmpIntList = new ArrayList<Integer>();
           for(TreeNode node : nodeList){
        	   TreeNode left = node.left;
        	   TreeNode right = node.right;
        	   if(left!=null){
        		   tmpNodeList.add(left);
        		   tmpIntList.add(left.val);
        	   }
        	   if(right!=null){
        		   tmpNodeList.add(right);
        		   tmpIntList.add(right.val);
        	   }
           }
           if(tmpIntList.size()!=0){
        	   rootList.add(tmpIntList);
           }
           nodeList = tmpNodeList;
		}
        return rootList; 
    }
}
