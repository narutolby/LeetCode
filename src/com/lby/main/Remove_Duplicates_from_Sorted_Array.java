package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-18
 * Time: 上午9:08
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] A) {
        int len = A.length,start = 0,point = 0;
        if(len == 0 || len == 1){
            return len;
        }
        for(int i=1;i<len;i++){
            if(A[i]!=A[start]){
                start++;
                A[start] = A[i];
            }
        }
        return start+1;
    }
}
