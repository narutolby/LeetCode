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
		if (head == null) {
			return null;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		int l = 0, r = list.size() - 1;
		return sortedListToBST(list, l, r);
	}

	public static TreeNode sortedListToBST(List<ListNode> list, int l, int r) {
		if (l <= r) {
			int m = (l + r) / 2;
			TreeNode root = new TreeNode(list.get(m).val);
			root.left = sortedListToBST(list, l, m - 1);
			root.right = sortedListToBST(list, m + 1, r);
			return root;
		}
		return null;
	}
}
