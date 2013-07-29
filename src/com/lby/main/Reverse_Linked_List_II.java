package com.lby.main;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 < m < n < length of list.
 */
public class Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode tmpHead = head,pH=null,pT=null;
		int num = 1;
		ListNode start=null;
		while (tmpHead!= null) {
			if(num==m-1){
				start = tmpHead;
			}
			if(num==n+1){
				pT.next = tmpHead;
			}
			if (num >= m && num <= n){
				if(num==m){
					pT = tmpHead;
					tmpHead = tmpHead.next;
					pT.next = null;
					pH = pT;
				}else{
					ListNode tmp = tmpHead.next;
					tmpHead.next = pH;
					pH = tmpHead;
					tmpHead = tmp;
				}
			}else{
					tmpHead = tmpHead.next;
			}
			num++;
		}
		if(m==1){
			start = pH;
		}else{
			start.next = pH;
            start = head;			
		}
		return start;
	}
}
