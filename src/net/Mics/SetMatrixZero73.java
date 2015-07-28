package net.Mics;

public class SetMatrixZero73 {
	public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return ;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m]; //true means set all row to 0
        boolean[] col = new boolean[n];
        for (int i=0; i<m ; i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i=0; i< m; i++){
            for (int j=0; j<n; j++){
                if (row[i]  || col[j] )
                    matrix[i][j] = 0;
            }
        }
    }
}
