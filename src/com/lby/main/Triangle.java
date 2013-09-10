package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-10
 * Time: 下午11:19
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
         int m = triangle.size();
         if(m == 0){
             return 0;
         }
         int n = triangle.get(m-1).size();
         int[][] table = new int[m][n];
         return minRoot(0,0,m-1,table,triangle);
    }
    public int minRoot(int level,int col,int maxDepth,int[][]table,ArrayList<ArrayList<Integer>> triangle){
         if(level == maxDepth){
             return triangle.get(level).get(col);
         }
         if(table[level][col]!=0){
             return table[level][col];
         }
         int min = Math.min(minRoot(level+1,col,maxDepth,table,triangle),minRoot(level+1,col+1,maxDepth,table,triangle));
         return table[level][col] = min+triangle.get(level).get(col);
    }
}
