package com.lby.main;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List {
	public ListNode deleteDuplicates(ListNode head) {
	  ListNode tmp = head;
	   while(head!=null){
		   if(head.next!=null){
			   if(head.val == head.next.val){
				   head.next = head.next.next;
				   continue;
			   }
		   }
		   head = head.next;
	   }
	   return tmp;
    }
}
