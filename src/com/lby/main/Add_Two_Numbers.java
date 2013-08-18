package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-18
 * Time: 下午5:42
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode head = l1,tail = null;
        while(l1!=null){
            if(l2!=null){
                int sum = l1.val + l2.val + pre;
                pre = sum / 10;
                l1.val = sum % 10;
                l2 = l2.next;
            }else{
              int sum = l1.val + pre;
              pre = sum / 10;
              l1.val = sum % 10;
            }
            if(l1.next == null){
                tail = l1;
            }
            l1 = l1.next;
        }
        if(tail == null) {
           head = l2;
        }else{
            tail.next = l2;
        }
        while(l2!=null){
            int sum = l2.val + pre;
            pre = sum / 10;
            l2.val = sum % 10;
            if(l2.next==null){
                tail = l2;
            }
            l2 = l2.next;
        }
        if(pre != 0){
           ListNode node = new ListNode(pre);
           tail.next = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        new Add_Two_Numbers().addTwoNumbers(l1, l2);
    }
}
