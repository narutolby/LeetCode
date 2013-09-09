package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-7
 * Time: 下午5:29
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region .

 For example,

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class Surrounded_Regions {
    public void solve(char[][] board) {
        if(board == null){
            return ;
        }
        int m = board.length;
        if(m==0)return;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,m,n);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1,m,n);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i,m,n);
            }
            if(board[m-1][i]=='O'){
                dfs(board,m-1,i,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    continue;
                }
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='D'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j,int m,int n){
        if(i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O'){ return;}
        board[i][j] = 'D';
        dfs(board, i+1, j, m, n);
        dfs(board, i-1, j, m, n);
        dfs(board, i, j+1, m, n);
        dfs(board, i, j-1, m, n);
    }
}
