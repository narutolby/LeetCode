package com.lby.main;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-10
 * Time: 上午1:25
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Longest_Common_Prefix {
    TreeNode root = new TreeNode((char) 0);
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        root.child.clear();
        for (String str : strs) {
            buildTree(str, root, 0);
        }
        ArrayList<Character> strlist = new ArrayList<Character>();
        StringBuilder sb = new StringBuilder();
        find(root, 0,sb, strs.length);
        return sb.toString();
    }

    public void find(TreeNode node, int start, StringBuilder sb, int len) {
        if (start!=0) {
            sb.append(node.c);
        }
        for (Map.Entry<Integer, TreeNode> entry : node.child.entrySet()) {
            TreeNode tmpNode = entry.getValue();
            if(tmpNode.count!=len) continue;
            find(tmpNode, start + 1, sb,len);
        }
    }

    public void buildTree(String str, TreeNode node, int i) {
        if (str.equals("")) return;
        if (i == str.length()) {
            return;
        }
        char c = str.charAt(i);
        if (node.child.containsKey((int) c)) {
            node.child.get((int) c).count++;
        } else {
            TreeNode subNode = new TreeNode(c);
            subNode.count++;
            node.child.put((int) c, subNode);
        }
        buildTree(str, node.child.get((int) c), i + 1);
    }

    class TreeNode {
        public char c;
        public int count;
        public HashMap<Integer, TreeNode> child = new HashMap<Integer, TreeNode>();
        TreeNode(char c) {
            this.c = c;
        }
    }

}
