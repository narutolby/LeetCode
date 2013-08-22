package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-22
 * Time: 下午9:42
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
  1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:

 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II {
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
