package com.lby.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Subsets_II {
    private Set<String> set = new HashSet<String>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        set.clear();
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
                String hashCode = this.getHashCode(sub);
                if (!set.contains(hashCode)) {
                    list.add(sub);
                    set.add(hashCode);
                }
            }
        }
        return list;
    }

    public String getHashCode(ArrayList<Integer> list) {
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = {1, 2};
        for (int i : array) {
            System.out.println(i);
        }
    }
    /*
     * The second method which does not need hashcode
     * More efficient
     */

    public ArrayList<ArrayList<Integer>> _subsetsWithDup(int[] S) {
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
            if (i != j && s[i - 1] == s[i]) {
                continue;
            }
            temp.add(s[i]);
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(temp);
            rootList.add(list);
            subset(s, rootList, temp, level + 1, length, i + 1);
            temp.remove(level);
        }
    }
}
