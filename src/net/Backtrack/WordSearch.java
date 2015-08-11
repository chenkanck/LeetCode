package net.Backtrack;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                if (helper(board, word, 0, i, j)) return true;
            }
        return false;
    }
    
	public boolean helper(char[][] board, String word, int cur,int x,int y){
        char tmp = board[x][y];
        if (cur>=word.length()) return true;
        if (cur == word.length()-1 && tmp == word.charAt(cur)) return true;
        if (tmp != word.charAt(cur))
            return false;
        board[x][y] = '#';
        if (x-1>=0 && helper(board, word, cur+1, x-1, y))
            return true;
        if (x+1<board.length && helper(board, word, cur+1, x+1, y))
            return true;
        if (y-1>=0 && helper(board, word, cur+1, x, y-1))
            return true;
        if (y+1<board[0].length && helper(board, word, cur+1, x, y+1))
            return true;
        board[x][y] = tmp;
        return false;
    }
    
}


