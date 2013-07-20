package com.lby.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author narutolby
 * 
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {

	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null){
			return null;
		}
	   List<ListNode> list = new ArrayList<ListNode>();
		while(head.next!=null){
			list.add(head);
		}
		return sortedListToBST1(list);
	}

	public static TreeNode sortedListToBST1(List<TreeNode> list) {
          		
		return null;
	}
}
