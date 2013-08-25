package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-9
 * Time: 下午11:53
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class Jump_Game {
    public boolean canJump(int[] A) {
      int len = A.length;
      if(len==0)return false;
      int cur = 0;
      while(cur < len-1 && A[cur]!=0){
         cur = cur + A[cur];
      }
      if(cur >= len-1) return true;
      else return false;
    }

    public boolean canJump_1(int[]A){
        int len = A.length;
        if(len == 0){return false;}
        if(len == 1){return true;}
        int start = 0;
        return dfs(A,start,len);
    }
    public boolean dfs(int[]A,int start,int len){
        if(A[start] == 0){return false;}
       for(int i=A[start];i>=1;i--){
            if(start+i>=len-1){return true;}
            boolean can = dfs(A,start+i,len);
            if(can){
                return can;
            }
        }
        return false;
    }
}
