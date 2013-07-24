package com.lby.main;

import java.util.Arrays;

/*
 *
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class Edit_Distance_1 {
	public int minDistance(String word1, String word2) {
		int l1 = word1.length(), l2 = word2.length();
		if(l1==0 || l2==0){
			return Math.abs(l1-l2);
		}
		int[][] dp = new int[l1+1][l2+1];
		int i, j;
		for (i = 0; i <= l1; i++) {
			dp[i][0] = i;
		}
		for (j = 0; j <= l2; j++) {
			dp[0][j] = j;
		}
		for (i = 1; i <= l1; i++) {
			for (j = 1; j <= l2; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(
							Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1),
							dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[l1][l2];
	}

}
