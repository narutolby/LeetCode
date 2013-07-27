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
             for(int i : S){
            	 int len = list.size();
            	 for(int j=0;j<len;j++){
            		 sub= new ArrayList<Integer>();
            		 sub.addAll(list.get(j)) ;
            		 sub.add(S[i]);
            		 list.add(sub);
            	 }
             }
             return list;
	    }
}
