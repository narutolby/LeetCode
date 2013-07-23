package com.lby.main;

import java.util.ArrayList;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:

 [
 [3],
 [20,9],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> rootList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> levelList = new ArrayList<Integer>();
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		if (root != null) {
			nodeList.add(root);
			levelList.add(root.val);
			rootList.add(levelList);
		}
		for (int i = 0; i < rootList.size(); i++) {
			ArrayList<TreeNode> tmpNodeList = new ArrayList<TreeNode>();
			ArrayList<Integer> tmpLevelList = new ArrayList<Integer>();
			for (int j = nodeList.size() - 1; j >= 0; j--) {
				TreeNode right= nodeList.get(j).right;
				TreeNode left= nodeList.get(j).left;
				if (i % 2 == 0) {
					if(right!=null){
						tmpNodeList.add(right);
						tmpLevelList.add(right.val);
					}
					if(left!=null){
						tmpNodeList.add(left);
						tmpLevelList.add(left.val);
					}
				}else{
					if(left!=null){
						tmpNodeList.add(left);
						tmpLevelList.add(left.val);
					}
					if(right!=null){
						tmpNodeList.add(right);
						tmpLevelList.add(right.val);
					}
				}
			}
			nodeList = tmpNodeList;
			if(tmpLevelList.size()!=0){
				rootList.add(tmpLevelList);
			}
		}
		return rootList; 
	}
}
