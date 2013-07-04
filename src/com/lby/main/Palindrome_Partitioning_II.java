package com.lby.main;
import java.util.Scanner;

public class Palindrome_Partitioning_II {
	public static int minCut(String s) {
		int len = s.length();
		int[][] F = new int[len][len];
		for (int i = 0; i < len; i++) {
			F[i][i] = 0;
		}
		for (int k = 2; k <= len; k++) {
			for (int i = 0; i <= len - k; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++) {
					if (j == i) {
						int ss = i, ee = i + k - 1;
						if (s.charAt(ss) == s.charAt(ee)
								&& (ss + 1 == ee || F[ss + 1][ee - 1] == 0)) {
							min = 0;
							break;
						}
					} else {
						if (F[i][j - 1] != 0) {
							continue;
						}
						min = Math.min(F[i][j - 1] + F[j][i + k - 1] + 1, min);
					}
				}
				F[i][i + k - 1] = min;
			}
		}
		return F[0][len - 1];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = null;
		while (sc.hasNext()) {
			str = sc.next();
			System.out.println(minCut1(str));
		}
	}

	public static int minCut1(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];
		dp[len-1][len-1]=0;
		for (int i = len - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
                 if(s.charAt(i)==s.charAt(j) && (j-i<=2  || dp[i+1][j-1]==0)){
                	 dp[i][j]=0;
                	 if(j+1==len){
                		 min=0;
                		 break;
                	 }else{
                		 min = Math.min(dp[j+1][len-1]+1, min);
                	 }
                 }else{
                	 dp[i][j]=-1;
                 }
			}
			dp[i][len-1] = min;
		}
		return dp[0][len-1];
	}
}
