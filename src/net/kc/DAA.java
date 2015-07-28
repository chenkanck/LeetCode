package net.kc;

public class DAA {
	public void hw11_FloydWarshall () {
		int max = 1000;
    	int[][][] D = new int [7][6][6];
		int[][] w = {{0, max,max, max, -1 , max},
					{1,0, max, 2, max, max},
					{max,2,0,max,max, -8},
					{-4,max,max,0,3,max},
					{max,7,max,max,0,max},
					{max,5,10,max,max,0}};
		D[0] = w;
		for (int[] s: w){
			for (int i: s)
				if (i >= 1000)
					System.out.print("@,");
				else
					System.out.print(i+",");
			System.out.println("");
		}
		
		for (int k =1; k<= 6; k++) {
			D[k] = new int[6][6];
			for (int i=0;i<6; i++){
				for (int j=0; j<6 ; j++){
					int a = D[k-1][i][k-1];
					int b = D[k-1][k-1][j];
				
					int c = a+b;
					if (c>= 500)
						c= 1000;
						
					D[k][i][j] = Math.min(D[k-1][i][j], c);
				}
			}
			System.out.println("#"+k);
			for (int[] s: D[k]){
				for (int i: s){
					if (i >=1000)
						System.out.print("@,");
					else
						System.out.print(i+",");
				}
				System.out.println("");
			}
		}
	}
}
