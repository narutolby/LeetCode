package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-27
 * Time: 下午11:51
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Spiral_Matrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(m==0){
            return list;
        }
        int n = matrix[0].length;
        int[][]print = new int[m][n];
        int x = 0,y = 0;
        char direction = 'r';
        for(int i = 0;i<m*n;i++){
            list.add(matrix[x][y]);
            print[x][y] = 1;
            if(direction == 'r'){
                if(y==n-1 || print[x][y+1]!=0){
                    direction = 'b';
                    x++;
                }else{
                    y++;
                }
            }else if(direction == 'b'){
                if(x==m-1 || print[x+1][y]!=0){
                    direction = 'l' ;
                    y--;
                }else{
                    x++;
                }
            }else if(direction == 'l'){
                if(y==0 || print[x][y-1]!=0) {
                    direction = 't';
                    x--;
                }else {
                    y--;
                }
            }else if(direction == 't'){
                if(x==0 || print[x-1][y]!=0){
                    direction = 'r';
                    y++;
                }else{
                    x--;
                }
            }
        }
        return list;
    }
    public static void main(String[]args){
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Spiral_Matrix().spiralOrder(matrix);
    }
}
