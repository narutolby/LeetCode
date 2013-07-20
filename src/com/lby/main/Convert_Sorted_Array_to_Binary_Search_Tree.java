package com.lby.main;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	 public TreeNode sortedArrayToBST(int[] num) {
            int len = num.length;
            if(len==0){
            	return null;
            }
            return sortedArrayToBST(num,0,len-1);
	    }
	 public TreeNode sortedArrayToBST(int[] num,int l,int r) {
           if(l<=r) {
                int m = (l+r)/2;        	   
                TreeNode root = new TreeNode(num[m]);
                root.left=sortedArrayToBST(num,l,m-1);
                root.right=sortedArrayToBST(num,m+1,r);
        	    return root;
           }
           return null;
		 
	 }
}
