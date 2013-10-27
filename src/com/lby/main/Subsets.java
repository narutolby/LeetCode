package com.lby.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        list.add(sub);
        Arrays.sort(S);
        for (int i : S) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                sub = new ArrayList<Integer>();
                sub.addAll(list.get(j));
                sub.add(i);
                list.add(sub);
            }
        }
        return list;
    }

    /*
     *第二种求全集方法
     */
    public ArrayList<ArrayList<Integer>> _subsets(int[] S) {
        int length = 0;
        ArrayList<ArrayList<Integer>> rootList = new ArrayList<ArrayList<Integer>>();
        if (S == null || (length = S.length) == 0) {
            return rootList;
        }
        Arrays.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        rootList.add(list);
        subset(S, rootList, temp, 0, length, 0);
        return rootList;
    }

    public void subset(int[] s, ArrayList<ArrayList<Integer>> rootList, ArrayList<Integer> temp, int level, int length, int j) {
        if (level == length) {
            return;
        }
        for (int i = j; i < length; i++) {
            temp.add(s[i]);
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(temp);
            rootList.add(list);
            subset(s, rootList, temp, level + 1, length, i + 1);
            temp.remove(level);
        }
    }
}
