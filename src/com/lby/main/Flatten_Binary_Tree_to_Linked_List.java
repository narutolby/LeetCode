package com.lby.main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-11
 * Time: 上午1:48
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given
           1
          / \
         2   5
        / \   \
       3   4   6
 The flattened tree should look like:
  1
   \
    2
     \
      3
       \
        4
         \
          5
           \
            6
 Hints:
 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class Flatten_Binary_Tree_to_Linked_List {

    /*用队列实现的flattern，利用的额外空间*/
    public void flatten(TreeNode root) {
        if(root == null) return ;
        QueueC queueC = new QueueC();
        preOrder(root,queueC);
        TreeNode point = queueC.out();
        while(!queueC.isEmpty()){
            point.right = queueC.out();
            point.left = null;
            point = point.right;
        }
        point.right = null;
    }
    public void preOrder(TreeNode root,QueueC queueC){
        if(root==null){
            return;
        }
        queueC.in(root);
        preOrder(root.left,queueC);
        preOrder(root.right,queueC);
    }
    class QueueC{
        private Queue<TreeNode> queue = new LinkedList<TreeNode>();
        public boolean isEmpty(){
            return queue.isEmpty();
        }
        public void in(TreeNode node){
            this.queue.offer(node);
        }
        public TreeNode out(){
           return  this.queue.poll();
        }
    }
    /**************************************************************************************/
    /*Second Method,通过，不利用额外的空间，只在原有的结构上变形*/
    /*思想：树的前序遍历的结果与将该树的右子树移到左子树最后一个结点的右子树的结果，相同，利用此递归求解*/

    public void _flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode left = root.left,tmpLeft = left;
        TreeNode right = root.right;
        if(left!=null){
            if(root.right!=null){
                while(tmpLeft.right!=null){
                    tmpLeft = tmpLeft.right;
                }
                tmpLeft.right = right;
            }
            root.right = left;
            root.left = null;
        }
        _flatten(root.right);

    }
}
