package com.lby.main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * @author narutolby
 *
 */
public class Binary_Tree_Level_Order_Traversal_II {
	 public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
              ArrayList<ArrayList<Integer>>	list = new ArrayList<ArrayList<Integer>>();
              if(root!=null){
            	  ArrayList<ArrayList<TreeNode>> rootList = new ArrayList<ArrayList<TreeNode>>();
                  ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
                  nodeList.add(root);
                  rootList.add(nodeList);
                  for(int i=0;i<rootList.size();i++){
                	  ArrayList<TreeNode> tmp = rootList.get(i);
                	  ArrayList<Integer> in = new ArrayList<Integer>();
                	  ArrayList<TreeNode> tmp1 = new ArrayList<TreeNode>();
                	  for(TreeNode node : tmp){
                		  in.add(node.val);
                		  if(node.left!=null){
                			  tmp1.add(node.left);
                		  }
                		  if(node.right!=null){
                			  tmp1.add(node.right);
                		  }
                	  }
                	  list.add(in);
                	  if(tmp1.size()!=0){
                		  rootList.add(tmp1);
                	  }
                  }
              }
              Collections.reverse(list);;
              return list;
	    }
}
