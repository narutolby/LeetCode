package com.lby.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-5
 * Time: 上午10:14
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */
public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode ret = new RandomListNode(-1),tmp = ret;
        while (head != null) {
            RandomListNode randomListNode = null;
            if(map.containsKey(head)){
                randomListNode = map.get(head);
            }else{
                randomListNode = new RandomListNode(head.label);
                map.put(head, randomListNode);
            }
            tmp.next = randomListNode;
            randomListNode = null;
            if(head.random!=null){
                if(map.containsKey(head.random)){
                    randomListNode = map.get(head.random);
                }else{
                    randomListNode = new RandomListNode(head.random.label);
                    map.put(head.random, randomListNode);
                }
            }
            tmp.next.random = randomListNode;
            tmp = tmp.next;
            head = head.next;
        }
        return ret.next;

    }
}
