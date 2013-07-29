package com.lby.main;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Search_a_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		
		if (matrix==null || matrix.length == 0) {
			return false;
		}
		int n = matrix[0].length, m = matrix.length;
		if(target<matrix[0][0] || target>matrix[m-1][n-1]){
			return false;
		}
		return searchMatrix(matrix, target, 0, n - 1, m, n);
	}

	public boolean searchMatrix(int[][] matrix, int target,int s, int e,
			int m, int n) {
		if (s > m - 1 || e < 0) {
			return false;
		}
		int ele = matrix[s][e];
		if (ele == target) {
			return true;
		} else if (target > ele) {
			return searchMatrix(matrix, target, s + 1, e, m, n);
		} else if (target < ele) {
			return searchMatrix(matrix, target, s, e - 1, m, n);
		}
		return false;
	}
}
