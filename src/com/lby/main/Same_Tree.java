package com.lby.main;
/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author narutolby
 *
 */
public class Same_Tree {
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		    if(p==null && q== null){
		    	return true;
		    }else if(p!=null && q!=null){
                  if(p.val!=q.val){
                	  return false;
                  }else{
                	  boolean is = isSameTree(p.left,q.left);
                	  return is?isSameTree(p.right,q.right):false;
                  }
		    }else{
		    	return false;
		    }
	 }
}
