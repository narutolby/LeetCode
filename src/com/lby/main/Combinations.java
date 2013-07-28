package com.lby.main;

import java.util.ArrayList;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> combines = new ArrayList<ArrayList<Integer>>();
		combine(n, k, combines, 1, 1, null);
		return combines;
	}

	public void combine(int n, int k, ArrayList<ArrayList<Integer>> list,
			int start, int level, ArrayList<Integer> sublist) {
		if (level > k) {
			return;
		}
		for (int i = start; i <= n - (k - level); i++) {
			ArrayList<Integer> tmpList = new ArrayList<Integer>();
			if(sublist!=null){
				tmpList.addAll(sublist);	
			}
			tmpList.add(level - 1, i);
			combine(n, k, list, i + 1, level + 1, tmpList);
			if (level == k) {
				list.add(tmpList);
			}
		}
	}
	public static void main(String[]args){
		System.out.println(new Combinations().combine(3, 2));
	}
}
