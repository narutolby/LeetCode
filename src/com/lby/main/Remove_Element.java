package com.lby.main;

import java.util.Arrays;

/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Remove_Element {
	public int removeElement(int[] A, int elem) {
        int s=0,x=0,len = A.length; 
        while(x<len){
        	if(A[x]!=elem){
        		A[s] = A[x];
        		s++;
        	}
        	x++;
        }
        return s;
    }
}
