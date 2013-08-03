package com.lby.main;
/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class Minimum_Path_Sum {
	public int minPathSum(int[][] grid) {
         int m = grid.length;        
         if(m==0){
        	 return 0;
         }
         int n = grid[0].length;
        int tmp = 0;
        for(int i=0;i<m;i++){
        	grid[i][0] += tmp;
        	tmp = grid[i][0];
        }
        tmp = 0;
        for(int i=0;i<n;i++){
        	grid[0][i] += tmp;
        	tmp = grid[0][i];
        }
        for(int i=1;i<n;i++){
        	for(int j=1;j<m;j++){
        		grid[j][i] = Math.min(grid[j][i-1], grid[j-1][i]);
        	}
        }
        return grid[m-1][n-1];
    }
}
