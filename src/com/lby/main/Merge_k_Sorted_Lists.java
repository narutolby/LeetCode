package com.lby.main;

import java.util.ArrayList;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * zhaomeng
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
         int len = lists.size(),end = 0;
         ListNode [] heap = new ListNode[len];
         for(ListNode node :lists) {
              if(node!=null){
                  heap[end] = node;
                  end++;
              }
         }
        if(end==0) return null;
        createMinHeap(heap,end);
        ListNode head = new ListNode(0),p = head;
        while(end!=0){
           p.next = heap[0];
           p = p.next;
           if(heap[0].next==null){
               heap[0] = heap[end-1];
               heap[end-1] = null;
               end--;
               buildMinHeap(heap,0,end);
           }else{
               heap[0] = heap[0].next;
               buildMinHeap(heap,0,end);
           }
        }
        return head.next;
    }

    public void buildMinHeap(ListNode[] heap, int root,int len) {
        int left = root * 2 + 1, right = root * 2 + 2, min = root;
        if (left < len && heap[left].val < heap[min].val) {
            min = left;
        }
        if (right < len && heap[right].val < heap[min].val) {
            min = right;
        }
        if (min != root) {
            ListNode  tmp = heap[min];
            heap[min] = heap[root];
            heap[root] = tmp;
            buildMinHeap(heap, min ,len);
        }
    }

    public void createMinHeap(ListNode[] heap, int len) {
        int end = len/2;
        for(int i=end;i>=0;i--){
            buildMinHeap(heap,i,len);
        }
    }
    public static void main(String[]args){
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode node = new ListNode(0);
        list.add(node);
        System.out.println(new Merge_k_Sorted_Lists().mergeKLists(list));
    }
}
