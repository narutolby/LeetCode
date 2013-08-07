package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-7
 * Time: 上午9:10
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].*
 */
public class Search_for_a_Range {
    public int[] searchRange(int[] A, int target) {
        int index = this._searchRange(A,target);
        if(index<0) {
            return new int[]{-1,-1};
        }
        int l=index,r=index;
        while(l>=0 && A[l]==target){
            l--;
        }
        while(r<A.length && A[r]==target){
            r++;
        }
        return new int[]{l+1,r-1};
    }
    public int _searchRange(int[]A,int target){
        int l = 0,r = A.length-1;
        int mid = -1;
        while(l<=r){
            mid = (l+r)/2;
            if(A[mid]==target){
               return mid;
            }else if(A[mid]<target){
               l = mid+1;
            }else{
               r = mid-1;
            }
        }
        return -1;
    }
}
