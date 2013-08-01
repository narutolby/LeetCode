package com.lby.main;
/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class Search_Insert_Position {
	public int searchInsert(int[] A, int target) {
    	if(A.length==0)return 0;
        return searchInsert(A,target,0,A.length-1);
    }
	public int searchInsert(int[] A, int target,int l,int r) {
		if(l>r){
    	 return l;   
		}
       
		int mid = (l+r)/2;
		if(A[mid]==target) return mid;
		else if(A[mid]<target){
			return searchInsert(A,target,mid+1,r);
		}else{
			return searchInsert(A,target,l,mid-1);
		}
	}
}
