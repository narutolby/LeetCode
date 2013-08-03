package com.lby.main;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Word_Search {

	public boolean exist(char[][] board, String word) {
		if (word == null || word.equals("") || board.length == 0) {
			return false;
		}
		int m = board.length, n = board[0].length;
		byte[][] map = new byte[m][n];
		char a = word.charAt(0);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]==a){
					map[i][j]=1;
					boolean checked = dfs(board,i,j,word,1,map,m,n);
					if(checked){
				       return true;		
					}
					map[i][j]=0;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int i, int j, String word, int index,
			byte[][] map, int m, int n) {
		if(index==word.length()){
			return true;
		}
		char left = 0, right = 0, top = 0, bottom = 0;
		if (j - 1 >= 0 && map[i][j - 1] == 0) {
			left = board[i][j - 1];
			if (left == word.charAt(index)) {
				map[i][j - 1] = 1;
				boolean checked = dfs(board, i, j - 1, word, index + 1, map, m, n);
				if (checked) {
					return true;
				}
				map[i][j - 1] = 0;
			}
		}
		if (j + 1 < n && map[i][j + 1] == 0) {
			right = board[i][j + 1];
			if (right == word.charAt(index)) {
				map[i][j + 1] = 1;
				boolean checked = dfs(board, i, j + 1, word, index + 1, map, m, n);
				if (checked) {
					return true;
				}
				map[i][j + 1] = 0;
			}
		}
		if (i - 1 >= 0 && map[i - 1][j] == 0) {
			top = board[i - 1][j];
			if (top == word.charAt(index)) {
				map[i - 1][j] = 1;
				boolean checked = dfs(board, i - 1, j, word, index + 1, map, m, n);
				if (checked) {
					return true;
				}
				map[i - 1][j] = 0;
			}
		}
		if (i + 1 < m && map[i + 1][j] == 0) {
			bottom = board[i + 1][j];
			if (bottom == word.charAt(index)) {
				map[i + 1][j] = 1;
				boolean checked = dfs(board, i + 1, j, word, index + 1, map, m, n);
				if (checked) {
					return true;
				}
				map[i + 1][j] = 0;
			}
		}
		return false;
	}

}
