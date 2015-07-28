package net.stringAndArray;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args){
		TwoSum t = new TwoSum();
		t.test();
		MaxPoint m = new MaxPoint();
		m.test();
		/**
		 * simplify path
		 */
//		String s1 = "..";
//		String s2 = "..";
//		System.out.println("equals?"+s1==s2);
//		SimplifyPath s = new SimplifyPath();
//		s.simplifyPath("/...");
		/**
		 * add and search
		 */
//		AddAndSearch a = new AddAndSearch();
//		a.addWord("a");
//		char[][] nn =  {{'O','O'},
//									  {'X','X'}
//		};
//		change(nn);
//		System.out.println(nn[0][0]);
//		solve(nn);
		String s = "abc";
		String sb = "a" + "bc";
		System.out.println(s == sb);
		System.out.println(s.equals(sb));
	}
	private static HashSet<String> set = new HashSet<>(Arrays.asList("ss"));
	
	private static void change(char[][] nn){
		nn[0][0] = 'y';
		nn[1][1] = 'y';
	}
	


    private static int m;
	private static int n;
    private static char[][] board;
    public static void solve(char[][] nn) {
        if (board==null || board.length == 0)
            return;
        board = nn;
        m = board.length;
        n = board[0].length;
        for (int i=0;i<m;i++){
            DFS(i,0);
            DFS(i,n-1);
        }
        for (int j=0;j<n;j++){
            DFS(0,j);
            DFS(m-1,j);
        }
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                if (board[i][j]=='D')
                  nn[i][j]='O';
                else if (board[i][j] == 'O')
                    nn[i][j]='X';
            }
    }
    
    public static void DFS (int x,int y){
        
        if (x<0|| x>=m || y<0 || y>=n ||board[x][y]!='O') return; 
        board[x][y] = 'D';
        DFS(x+1,y);
        DFS(x-1,y);
        DFS(x,y-1);
        DFS(x,y+1);
    }

}
