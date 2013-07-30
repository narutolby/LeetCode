package com.lby.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Set_Matrix_Zeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix.length==0){
			return ;
		}
		Set<Integer> row  = new HashSet<Integer>();
		Set<Integer> column = new HashSet<Integer>();
		int m = matrix.length,n = matrix[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0){
					row.add(i);
					column.add(j);
				}
			}
		}
		for(Iterator<Integer> i = row.iterator();i.hasNext();){
			Arrays.fill(matrix[i.next()], 0);
		}
		for(Iterator<Integer> i = column.iterator();i.hasNext();){
			int c = i.next();
			for(int j=0;j<m;j++){
				matrix[j][c] = 0;
			}
		}
    }
}
