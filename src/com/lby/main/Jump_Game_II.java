package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-25
 * Time: 下午4:38
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Jump_Game_II {
    private int minSteps;


    public int jump(int[] A) {
        minSteps= Integer.MAX_VALUE;
        int len = A.length;
        if(len == 0 || len == 1){minSteps = 0;return minSteps;}
        int start = 0,step = 0;
        int []dp = new int[len];
        //dfs(A,start,len,step,dp);
        DP(A,dp);
        //return minSteps;
        return dp[0];
    }
    /*
     * dfs+查表小数据测试通过，大数据不过
     */
    public void dfs(int[]A,int start,int len,int step,int[]dp){
        if(start>=len-1){
            if(step<minSteps){
                minSteps = step;
            }
        }else{
            if(A[start] == 0){return;}
            if(dp[start]!=0){
                step = step + dp[start];
                if(step<minSteps){
                    minSteps = step;
                }
                return;
            }
            for(int i=A[start];i>=1;i--){
                dfs(A,start+i,len,step+1,dp);
            }
            if(minSteps!=Integer.MAX_VALUE){
                if(dp[start]<minSteps-step){
                    dp[start] = minSteps-step;
                }
            }
        }
    }
    /*
     * dp小数据测试通过，大数据依然不过，我ca,是否哪里可以进行剪枝优化？
     */

    public void DP(int[]A,int[]dp){
        int len = A.length,MAX = Integer.MAX_VALUE;
        if(len == 0){return;}
        dp[len-1] = 0;
        for(int i=len-2;i>=0;i--){
            if(A[i]==0){
                continue;
            }
            if(A[i]+i>=len-1){
                dp[i] = 1;
            }else{
                int min = MAX;
                for(int j=A[i];j>=1;j--){
                    if(A[i+j]==0 || dp[i+j]==MAX){
                        continue;
                    }
                    if(min>1+dp[i+j]){
                       min = 1+dp[i+j];
                    }
                }
                dp[i] = min;
            }
        }
    }

    /*
     * discussion一个人的写法，尝试一下,依然大数据不过，好吧，暂时放弃
     */

    public int thirdMethod(int[]A,int last){
        if(last==0){return 0;}
        int min = Integer.MAX_VALUE;
        for(int i=last;i>=0;i--){
           if(A[i]+i>=last){
              int steps = 1+thirdMethod(A,i);
              if(min > steps){
                  min = steps;
              }
           }
        }
        return min;
    }
}
