package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: naruto
 * Date: 13-8-26
 * Time: 下午10:54
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */
public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m = obstacleGrid.length;
       if(m==0){return 0;}
       int n = obstacleGrid[0].length;
       if(obstacleGrid[0][0]==1){
           return 0;
       }
       int[][]dp = new int[m][n];
       for(int i=0;i<m;i++){
           if(obstacleGrid[m][0]==1){
               continue;
           }
           dp
       }

    }
}
