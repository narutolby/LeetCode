package com.lby.main;

import java.util.Arrays;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class Unique_Binary_Search_Trees {
	public int numTrees(int n) {
       int[]dp = new int[n+1];        
       Arrays.fill(dp, 0);
       dp[0] = 1;
       for(int i=1;i<=n;i++){
    	   for(int j=1;j<=i;j++){
    		   dp[i] += dp[j-1]*dp[i-j];
    	   }
       }
       return dp[n];
    }
}
