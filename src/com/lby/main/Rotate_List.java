package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-7
 * Time: 上午12:43
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class Rotate_List {
    public ListNode rotateRight(ListNode head, int n) {
        if(n == 0 || head == null || n==1 && head.next==null){return head;}
        int count = 0;
        ListNode node = head,tail = head,prev = new ListNode(0);prev.next = head;
        while(node!=null){
            count ++;
            node = node.next;
        }
        n = n>count ? n : n % count;
        node = head;count = 0;
        while(node!=null){
            count++;
            if(count >= n+1){
                prev = prev.next;
            }
            if(node.next==null){
                tail = node;
                break;
            }

            node = node.next;
        }
      if(count < n+1){return head;}
      tail.next = head;
      head = prev.next;
      prev.next = null;
      return head;
    }
}
