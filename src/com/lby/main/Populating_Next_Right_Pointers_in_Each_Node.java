package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-21
 * Time: 下午8:49
 *  Given a binary tree
 *
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
        1
       /  \
      2    3
     / \  / \
    4  5  6  7
     After calling your function, the tree should look like:

        1 -> NULL
      /  \
     2 -> 3 -> NULL
    / \  / \
   4->5->6->7 -> NULL
 */
public class Populating_Next_Right_Pointers_in_Each_Node {
    public void connect(TreeLinkNode root) {
       if(root == null) return;
       ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
       list.add(root);
       while(list.size()!=0){
           ArrayList<TreeLinkNode> tmpList = new ArrayList<TreeLinkNode>();
           for(int i=0;i<list.size();i++){
               list.get(i).next =  (i+1==list.size()? null : list.get(i+1));
               if(list.get(i).left!=null){
                   tmpList.add(list.get(i).left);
               }
               if(list.get(i).right!=null){
                   tmpList.add(list.get(i).right);
               }
           }
           list = tmpList;
       }
    }
}
