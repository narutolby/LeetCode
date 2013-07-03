import java.net.URL;
import java.util.ArrayList;

public class leet2 {
	private static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

	public static ArrayList<ArrayList<String>> partition(String s) {
		int len = s.length();
		int[][] dp = minCut1(s, len);
        recurse(s,0,len);
		return list;
	}

	public static void recurse(String s, int start,int len) {
          if(start == len-1){
        	  
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
