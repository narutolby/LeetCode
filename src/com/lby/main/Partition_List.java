package com.lby.main;

import com.sun.tools.internal.ws.processor.model.jaxb.JAXBTypeAndAnnotation;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-22
 * Time: 下午9:46
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ArrayList<ListNode> before = new ArrayList<ListNode>();
        ArrayList<ListNode> after = new ArrayList<ListNode>();
        while(head!=null){
           if(head.val < x) {
              before.add(head);
           }else{
              after.add(head);
           }
           head = head.next;
        }
        ListNode node  = new ListNode(0);
        head = node;
        for(int i=0;i<before.size();i++){
           head.next = before.get(i);
           head = head.next;
        }
        for(int i=0;i<after.size();i++){
            head.next =after.get(i);
            head = head.next;
        }
        head.next = null;
        return node.next;
    }
}
