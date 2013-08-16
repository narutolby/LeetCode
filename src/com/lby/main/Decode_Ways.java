package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-15
 * Time: 上午10:43
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        int len = s.length();
        if(s == null || len == 0){
            return 0;
        }
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='0'){
                dp[i][i] = 1;
            }else{
                dp[i][i] = 0;
            }
        }
        for(int i=0;i<=len-2;i++){
            String str = s.substring(i,i+2);
            int num = Integer.valueOf(str);
            if(num%10==0 && num!=0) {
                dp[i][i+1] = 1;
            }else if(num<10){
                dp[i][i+1] = 0;
            }else if(num>26){
                dp[i][i+1] = 1;
            }else{
                dp[i][i+1] = 2;
            }
        }
        for(int i=2;i<len;i++) {
            for(int j=0;j<i;j++){
                dp[0][i] += dp[0][j] * dp[j+1][i];
            }
            if(dp[0][i]!=0){dp[0][i] -= (i-1);}
        }
        return dp[0][len-1];
    }
}
