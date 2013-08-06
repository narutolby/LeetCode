package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-6
 * Time: 上午9:44
 *
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array A = [1,1,1,2,2,3],
 Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] A) {
       int start = 0,count = 1,len = A.length;
       if(len==0 || len==1){
           return len;
       }
       for(int i=1;i<len;i++){
          if(A[i]==A[i-1] && count<2 || A[i]!=A[i-1]){
              if(A[i]!=A[i-1]){
                  count=0;
              }
              count++;
              start++;
              A[start]=A[i];
          }
       }
       return start+1;
    }
}
