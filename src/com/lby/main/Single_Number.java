package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-5
 * Time: 下午1:45
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number {
    public int singleNumber(int[] A) {
        int len = A.length;
        if(len==0){
            return -1;
        }
        int aws = A[0];
        for(int i=1;i<len;i++){
            aws = aws ^ A[i];
        }
        return aws;
    }
}
