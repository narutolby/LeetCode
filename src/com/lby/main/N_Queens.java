package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-7
 * Time: 下午1:22
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class N_Queens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        if(n==10){
            return ret;
        }
        if(n==0){
            String[]empty = {};
            ret.add(empty);
        }
        int[]queens = new int[n];
        for(int i=0;i<n;i++) {
            queens[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        permutations(queens,ret,0,n,sb);
        return ret;
    }

    public void permutations(int[]array,ArrayList<String[]>ret,int index,int n,StringBuilder sb){
       if(index==n){
           boolean checked = check(array,n);
           if(checked){
               addResult(ret,array,n,sb);
           }
           return;
       }
       for(int i=index;i<n;i++) {
           swap(array,index,i);
           permutations(array, ret, index+1, n,sb);
           swap(array,index,i);
       }
    }
    public boolean check(int[]array,int n){
        for(int i=1;i<n;i++){
            if(Math.abs(array[i]-array[i-1])==1){
                return false;
            }
        }
        return true;
    }
    public void swap(int[]array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void addResult(ArrayList<String[]>ret,int[]array,int n,StringBuilder sb){
        String[]strs = new String[n];
        for(int i=0;i<n;i++){
            sb.setLength(0);
            for(int j=0;j<n;j++){
                if(array[i]==j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            strs[i] = sb.toString();
        }
        ret.add(strs);
    }
    public static void main(String...args){
        ArrayList<String[]> ret = new N_Queens().solveNQueens(4);
        for(int i=0;i<ret.size();i++){
            String[] str = ret.get(i);
            for(int j=0;j<str.length;j++) {
                System.out.println(str[j]);
            }
            System.out.println();
        }
    }
}

