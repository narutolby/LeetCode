package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-28
 * Time: 上午1:14
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int [][]ret = new int[n][n];
        int x = 0,y = 0;
        char direction = 'r';
        for(int i = 0;i<n*n;i++){
            ret[x][y] = i+1;
            if(direction == 'r'){
                if(y==n-1 || ret [x][y+1]!=0){
                    direction = 'b';
                    x++;
                }else{
                    y++;
                }
            }else if(direction == 'b'){
                if(x==n-1 || ret[x+1][y]!=0){
                    direction = 'l' ;
                    y--;
                }else{
                    x++;
                }
            }else if(direction == 'l'){
                if(y==0 || ret[x][y-1]!=0) {
                    direction = 't';
                    x--;
                }else {
                    y--;
                }
            }else if(direction == 't'){
                if(x==0 || ret[x-1][y]!=0){
                    direction = 'r';
                    y++;
                }else{
                    x--;
                }
            }
        }
        return ret;

    }
}
