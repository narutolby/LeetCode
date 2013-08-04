package com.lby.main;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode top = new ListNode(0);
		top.next = head;
        ListNode n1 = head,n2 = null;
        int count = 0;
        while(n1!=null){
        	count++;
        	if(count>n){
        		n2 = top.next;
        		top = top.next;
        	}
        	n1=n1.next;
        }
        if(n2==null){
        	head=head.next;
        }else{
        	n2.next = n2.next.next;
        }
        return head;
	}
}
