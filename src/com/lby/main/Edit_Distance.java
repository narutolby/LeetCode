package com.lby.main;

import java.util.Arrays;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class Edit_Distance {
	/*
	 * 递归写法
	 */
	public int minDistance(String word1, String word2) {
		int l1 = word1.length(), l2 = word2.length();
		if (l1 == 0 || l2 == 0) {
			return Math.abs(l1 - l2);
		}
		int dp[][] = new int[l1][l2];
		for (int i = 0; i < l1; i++) {
			Arrays.fill(dp[i], -1);
		}
		return minDistance(word1, word2, 0, 0, l1, l2, dp);
	}

	public int minDistance(String word1, String word2, int s1, int s2, int l1,
			int l2, int[][] dp) {
		if (s1 == l1) {
			return l2 - s2;
		}
		if (s2 == l2) {
			return l1 - s1;
		}
		if (word1.charAt(s1) == word2.charAt(s2)) {
			if (dp[s1][s2] != -1) {
				return dp[s1][s2];
			} else {
				return dp[s1][s2] = minDistance(word1, word2, s1 + 1, s2 + 1,
						l1, l2, dp);
			}
		} else {
			return dp[s1][s2] = Math.min(Math.min(
					minDistance(word1, word2, s1, s2 + 1, l1, l2, dp) + 1,
					minDistance(word1, word2, s1 + 1, s2, l1, l2, dp) + 1),
					minDistance(word1, word2, s1 + 1, s2 + 1, l1, l2, dp) + 1);
		}
	}
}
