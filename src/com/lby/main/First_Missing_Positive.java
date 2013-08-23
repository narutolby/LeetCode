package com.lby.main;
/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class First_Missing_Positive {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        if(len==0){
            return 1;
        }
        int i = 0;
        while(i<len){
            if(A[i]>=1 && A[i]<=len && A[i]!=i+1 && A[A[i]-1]!=A[i]) {
                int tmp = A[i],tmp1 = A[tmp-1];
                A[i] =  tmp1;
                A[tmp-1] = tmp;
                continue;
            }
            i++;
        }
        i=0;
        while(i<len && A[i]==i+1){
            i++;
        }
        return i+1;

    }

    public int firstMissingPositive_1(int[] A) {
        int len = A.length;
        if(len==0){
            return 1;
        }
        int[]map = new int[len];
        for(int i=0;i<len;i++){
            if(A[i]<1 || A[i]>len){
                continue;
            }
            map[A[i]-1] = 1;
        }
        int i = 0;
        for(i=0;i<len && map[i]!=0;i++){}
        return i+1;
    }
    public static void main(String[]args){
        int[]a = {0};
        System.out.println(new First_Missing_Positive().firstMissingPositive(a));
    }
}
