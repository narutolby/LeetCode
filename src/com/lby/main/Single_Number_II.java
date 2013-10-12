package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-5
 * Time: 下午1:53
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_II {
    public int singleNumber(int[] A) {
        if(A==null){
            return 0;
        }
        int len = A.length;
        if(len==0){
            return 0;
        }
        int[]count = new int[32];
        for(int i=0;i<len;i++){
            for(int j=0;j<32;j++){
                count[j] += (A[i]>>j & 1 );
                count[j] %= 3;
            }
        }
        int ret = 0;
        for(int i=0;i<32;i++){
            ret += (count[i]<<i);
        }
        return ret;
    }
}
