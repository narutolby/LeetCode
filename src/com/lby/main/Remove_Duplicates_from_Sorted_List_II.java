package com.lby.main;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
		Map<Integer,Integer> map= new HashMap<Integer,Integer>();
		ListNode tmpHead = head;
		while (tmpHead != null) {
			if(map.get(tmpHead.val)==null){
				map.put(tmpHead.val, 0);
			}else{
				map.put(tmpHead.val, map.get(tmpHead.val)+1);
			}
			tmpHead = tmpHead.next;
		}
		tmpHead = head;
		ListNode prev = head;
		while (prev != null && map.get(prev.val)!=0) {
			prev = prev.next;
		}
		if(prev==null){
			return null;
		}
		head = prev;
		tmpHead = prev.next;
		while (tmpHead != null) {
			if (map.get(tmpHead.val)!=0) {
                prev.next = tmpHead.next;
                tmpHead = tmpHead.next;
			}else{
    		     prev = tmpHead;
    	      	 tmpHead = tmpHead.next;
			}
           
		}
		return head;
	}
}
