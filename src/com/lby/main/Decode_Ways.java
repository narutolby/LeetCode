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
    /*递归方式求解 , 小数据可以过，大数据过不了,应该用dp方式求解*/
    public int numDecodings(String s) {
        int len = s.length();
        if(len==0){
            return 0;
        }
        return numDecodings(s,0,len);
    }
    public int numDecodings(String s,int start,int len){
        char c ;
         if(start==len){
             return 1;
         }
        if((c=s.charAt(start))=='0'){
            return 0;
        }
         int ans = 0;
         ans += numDecodings(s,start+1,len);
         if(start+1<=len-1  && (c=='1' || (c=='2' && s.charAt(start+1)<='6'))){
             ans += numDecodings(s,start+2,len);
         }
         return  ans;
    }


    /*dp方式求解*/
    public int numDecodingsDP(String s){
       int len = s.length();
       if(len==0 || s.charAt(0)=='0'){
           return 0;
       }
       int[]dp = new int[len+1];
       dp[0] = 1;
       for(int i=1;i<=len;i++){
           int c1 = 0,c2=0;
           char c = s.charAt(i-1);
           if(c!='0'){
               c1 = dp[i-1];
           }
           if(i>=2){
               if(s.charAt(i-2)=='1' || s.charAt(i-2) == '2' && s.charAt(i-1)<='6'){
                   c2 = dp[i-2];
               }
           }
           dp[i] = c1 + c2;
       }
       return dp[len];
    }
}
