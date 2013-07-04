package com.lby.main;

import java.util.ArrayList;
import java.util.Scanner;

public class leet2 {
	private static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	private static int[][] dp;

	public static ArrayList<ArrayList<String>> partition(String s) {
		list.clear();
		int len = s.length();
		dp = minCut1(s, len);
		recurse(s, 0, len, null,0);
		System.out.println(list);
		return list;
	}

	public static void recurse(String s, int start, int len,
			ArrayList<String> array,int num) {
		if (start == len) {
			list.add(array);
			return;
		}
		for (int i = start; i < len; i++) {
			ArrayList<String> tmp = array;
			array = new ArrayList<String>();
			if(tmp!=null){
				for(int j=0;j<num;j++){
					array.add(tmp.get(j));
				}
			}
			if (dp[start][i] == 0) {
				array.add(s.substring(start, i + 1));
				num++;
				recurse(s, i + 1, len, array,num);
				num--;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = null;
		while (sc.hasNext()) {
			str = sc.next();
			partition(str);
		}
	}

	public static int[][] minCut1(String s, int len) {
		int[][] dp = new int[len][len];
		dp[len - 1][len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 2 || dp[i + 1][j - 1] == 0)) {
					dp[i][j] = 0;
					if (j + 1 == len) {
						min = 0;
						break;
					} else {
						min = Math.min(dp[j + 1][len - 1] + 1, min);
					}
				} else {
					dp[i][j] = -1;
				}
			}
			dp[i][len - 1] = min;
		}
		return dp;
	}
}
