package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-11
 * Time: 下午9:03
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Maximal_Rectangle {
    /*
     * 小数据测试通过，大数据不过，另寻优化方法
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] table = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    table[j][i] = (matrix[j][i] == '1' ? 1 : 0);
                } else {
                    table[j][i] = (matrix[j][i] == '1' ? (1 + table[j - 1][i]) : table[j - 1][i]);
                }
            }
        }
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if((j-i+1)*n<=area){
                    continue;
                }
                int tmpArea = 0;
                int width = 0;
                for (int x = 0; x < n; x++) {
                    int count = (i == 0 ? table[j][x] : table[j][x] - table[i - 1][x]);
                    if (i == 0 && count != j+1 || i != 0 && count != j - i + 1) {
                        area = Math.max(area,tmpArea);
                        tmpArea = 0;
                        if(n-x-1<=width){
                            break;
                        }
                        width = 0;
                    }else{
                        tmpArea+=count;
                        width++;
                    }
                }
                area = Math.max(area,tmpArea);

            }
        }
        return area;
    }
    public static void main(String[]args){
        char[][] c= {{'0','1'}};
        new Maximal_Rectangle().maximalRectangle(c);
    }
}

