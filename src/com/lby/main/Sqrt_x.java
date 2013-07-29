package com.lby.main;
/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Sqrt_x {
	public int sqrt(int x) {
		if(x<=1){
			return x;
		}
		int left = 0,right = x,mid=0;
		while((right-left)>1){
			mid = left + (right-left)/2;
			if(x/mid==mid){
				return mid;
			}else if(x/mid<mid){
				right = mid;
			}else{
				left = mid;
			}
		}
		return left;
    }
}
