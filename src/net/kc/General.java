package net.kc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

public class General {
	/*
	 * Given two binary strings, return their sum (also a binary string).
	 */
	public static String addBinary(String a, String b) {
        String longStr = a;
        String shortStr = b;
        if (a.length() < b.length()){
            longStr = b;
            shortStr = a;
        }
        String tmp = "";
        int carry=0;
        int subSum = 0;
        int ll = longStr.length();
        int sl = shortStr.length();
        for (int i=1; i<= sl ; i++){
            subSum = 0;
            if (shortStr.charAt(sl-i) == '1')
                subSum++;
            if (longStr.charAt(ll-i) == '1')
                subSum++;
            if (carry == 1)
                subSum++;
            
            if (subSum <2 ){
                tmp = Integer.toString(subSum)+tmp;
                carry = 0;
            }
            else {
                tmp = Integer.toString(subSum-2)+tmp;
                carry = 1;
            }
        }
        for (int i = sl+1 ; i<= ll ;i++){
        
            if (carry == 0)
               
            	tmp = longStr.substring(ll-i,ll-i+1) + tmp;
            else if (longStr.charAt(ll-i) == '0') {
                carry =0;
                tmp = "1"+tmp;
            } 
            else{
                carry = 1;
                tmp = "0"+tmp;
            }
        }
        
        if (carry == 1)
            tmp = "1"+tmp;
        return tmp;
	}
	/*
	 * 
	 */
	public String addBinary2(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        // a is longer than b
        int pa = a.length()-1;
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";
        
        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
            pb --;
        }
        
        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }       
        
        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }

	public boolean isValidSudoku(char[][] board) {
        //check row and column
        for (int i=0 ; i<9 ;i++){
            
            Hashtable<Character,Character> rowH= new Hashtable<Character,Character>();
            Hashtable<Character,Character> colH= new Hashtable<Character,Character>();
            for (int j=0;j<9 ;j++){
                char row = board[i][j];
                char col = board[j][i];
                if (row != '.' )
                    if (!rowH.containsKey(row))
                        rowH.put(row,row);
                    else
                        return false;
                if (col != '.')
                    if (!colH.containsKey(col))
                        colH.put(col,col);
                    else
                        return false;
                
            }
        }
        //check box
        ArrayList<Hashtable<Character,Character>> box= new ArrayList<Hashtable<Character,Character>>();
        for (int n = 0;n<9;n++) 
        	box.add(new Hashtable<Character,Character>());
        for (int i=0;i<9;i++)
            for (int j=1;j<9;j++){
                int row = i/3; // 0,1,2
                int col = j/3;
                int index = row*3+col;
                char c = board[i][j];
                if (c!='.')
                    if (box.get(index).containsKey(c))
                        return false;
                    else 
                        box.get(index).put(c,c);
            }
        
        return true;
    }
	public void runn () {
		char[][] board = new char[9][9];
		for (int i=0;i<9;i++)
			for (int j=0;j<9;j++)
			{
//				if ((Math.random()*5)<4)
//					board[i][j]='.';
//				else
//					board[i][j]= String.valueOf((int)(Math.random()*9)+1).charAt(0);
				board[i][j]='.';
			}
		board[5][3]='5';
		System.out.println(this.isValidSudoku(board));
	}
	
	
	public static void merge(int A[], int m, int B[], int n) {
        int index_B=0;
        int index_A=0;
        int index_C=0;
        int[] C = new int[m+n];
        while (index_A < m && index_B < n){
            if (A[index_A]<=B[index_B]){
                C[index_C]=A[index_A];
                index_A++;
            }
            else{
                C[index_C]=B[index_B];
                index_B++;
            }
            index_C++;
        }
        if (index_A>=m) //all remaining elements are in B
        {
            while (index_B <n){
                C[index_C]= B[index_B];
                index_B++;
                index_C++;
            }
        }else 
        {
            while (index_A <m){
                C[index_C]= A[index_A];
                index_A++;
                index_C++;
            }
        }
        A = C;
    }
	
	/*
	 * ZigZag convert
	 */
	 public static String convert(String s, int nRows) {
	        if (s.length()<0)
	            return null;
	        if (nRows<=1)
	            return s;
	        int part = 2*nRows-2;
	        String[] result = new String[nRows];
	        for (int i=0;i<s.length();i++){
	            int part_index = i%part;
	            if (part_index > part/2 ){
	                result[part-part_index]+=String.valueOf(s.charAt(i));
	            }else{
	                result[part_index]+=String.valueOf(s.charAt(i));
	            }
	        }
	        
	        String coverted = "";
	        for (int i=0; i<nRows; i++)
	            if (result[i]!=null)
	                coverted+=result[i];
	            
	        return coverted;
	    }
	 
	 private Comparator<Integer> compare = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		 
	 };
}
