package com.lby.main;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-11
 * Time: 下午4:00
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return;
        }
        int level = len / 2;
        for (int j = 1; j <= level; j++) {
            int start = j - 1, end = len - j;
            for(int i= start;i<end;i++){

            int top = matrix[start][i];
            //left fo top
            matrix[start][i] = matrix[start+end-i][start];
            //bottom to left
            matrix[start+end-i][start] = matrix[end][start+end-i];
           //right to bottom
            matrix[end][start+end-i] = matrix[i][end];
            //top to right
            matrix[i][end] = top;
            }
        }

    }
    public static void main(String[]args){
        int[][] a = {{1,2},{3,4}};
        new Rotate_Image().rotate(a);
    }
}
