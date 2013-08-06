package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-7
 * Time: 上午12:23
 *Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
       ListNode p1 = head,p2 = head.next,node = new ListNode(0);
       node.next = head;
       int i=0;
       while(p1!=null && p2!=null){
          p1.next = p2.next;
          p2.next = p1;
           if(i==0){
               head = p2;
           }
           node.next = p2;
           ListNode tmp = p1;
           p1=p2;p2 = tmp;
           node = p2;
           p1 = p2.next;
           if(p1!=null) {
               p2 = p1.next;
           }
           i++;
       }
        return head;
    }
}
