package net.kc;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;


//
//import java.util.regex.Pattern;
//
//
//public class Helloworld {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		compareVersion("0","1");
////		atoi("-1");
//		int[][] i = {
//				{1,2,3},
//				{4,5,6}
//			
//		};
//		System.out.println(i.length+" "+ i[0].length);
////		General.convert("A", 2);
////		int[] A = {};
////		int[] B = {1};
////		General.merge(A, 0, B, 1);
//	
////		WorkWithTree tree = new WorkWithTree();
////		tree.play();
////		String s= "hello world";
////		char c = s.charAt(0);
////		c-=32;
////		String ss = Character.toString(c);
////		System.out.println(c+"\n"+ss);
////		WorkWithList workPlace = new WorkWithList();
////		workPlace.showList();
////		workPlace.play();
////		String s = "fadf,fjasf\"ssss";
////		System.out.println(s);
////		Pattern p = Pattern.compile(",|\"");
////		String [] ss = s.split(",|\"");
////		for (String str : ss){
////			System.out.println(str);
////		}
////		General g = new General();
////		g.runn();
//	}
//	public static int compareVersion(String version1, String version2) {
//        String[] ver1 = version1.split("\\.");
//        String[] ver2 = version2.split("\\.");
//        int index;
//        if (ver1.length > ver2.length)
//            index = ver2.length;
//        else
//            index = ver1.length;
//        for (int i=0; i<index ;i++){
//            int ver1int = Integer.parseInt(ver1[i]);
//            int ver2int = Integer.parseInt(ver2[i]);
//            if ( ver1int < ver2int )
//                return -1;
//            if ( ver1int > ver2int)
//                return 1;
//        }
//        if (ver1.length == ver2.length)
//            return 0;
//        else if (ver1.length > ver2.length)
//            return 1;
//        else 
//            return -1;
//            
//    }
//	public static void reverseword ()
//	{
//		String s=" Hello the World    the world ";
//		String[] splitS=s.split(" ");
//		String revS = "";
//		for (int i=0;i< splitS.length;i++)
//		{
//			String t = splitS[i];
//			if (!t.isEmpty())
//			{
//				revS =t + revS;
//				if (i < splitS.length-1 )
//					revS =" "+revS;
//			}
//		}
//		System.out.printf(revS);
//	}
//	
//	public static int atoi(String str) {
//        if(str == null) {
//            return 0;
//        }
//        str = str.trim();
//        if (str.length() == 0) {
//            return 0;
//        }
//            
//        int sign = 1;
//        int index = 0;
//    
//        if (str.charAt(index) == '+') {
//            index++;
//        } else if (str.charAt(index) == '-') {
//            sign = -1;
//            index++;
//        }
//        long num = 0;
//        for (; index < str.length(); index++) {
//            if (str.charAt(index) < '0' || str.charAt(index) > '9')
//                break;
//            num = num * 10 + (str.charAt(index) - '0');
//            if (num > Integer.MAX_VALUE && sign == 1) {
//                break;
//            }
//        }   
//        if (num * sign > Integer.MAX_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//        if (num * sign < Integer.MIN_VALUE) {
//            return Integer.MIN_VALUE;
//        }
//        return (int)num * sign;
//    }
//}

public class Helloworld {
    private char[][] rst= new char[9][9];
    public void solveSudoku(char[][] board) {
        helper(0,board);
        for (int i=0;i<9;i++)
            System.arraycopy(rst[i],0,board[i],0,9);
    }
    
    public void helper (int count, char[][] board){
        if (count>80){
            for (int i=0;i<9;i++)
                System.arraycopy(rst[i],0,board[i],0,9);
            // rst=board;
            return ;
        }
        int curRow= count/9;
        int curCol= count%9;
        if (board[curRow][curCol]=='.'){
            for (int t=1;t<=9;t++){
                boolean valid=true;
            //check row
                for (int col=0;col<9;col++) 
                    if (Character.getNumericValue(board[curRow][col])==t){
                        valid=false;
                        break;
                    }
            //check col
                for (int row=0;row<9;row++)
                    if (Character.getNumericValue(board[row][curCol])==t){
                        valid=false;
                        break;
                    }
            //check square
                int m=(curRow/3)*3;
                int n=(curCol/3)*3;
                for (int i=m;i<m+3;i++)
                    for (int j=n;j<n+3;j++)
                        if (Character.getNumericValue(board[i][j])==t){
                            valid=false;
                            break;
                        }
                if (valid){
                    //deep copy
                    // char[][] newBoard = new char[9][9];
                    // for (int i=0;i<9;i++)
                    //     System.arraycopy(board[i],0,newBoard[i],0,9);
                    // newBoard[curRow][curCol]=(char)(t+48);
                    // helper(count+1, newBoard);
                    board[curRow][curCol]=(char)(t+48);
                    helper(count+1,board);
                    board[curRow][curCol]='.';
                }//end if
            }//end for
        }else{
            helper(count+1, board);
        }
    }
    private void helper(Map<Character, char[]> map, String digits,StringBuilder sb, ArrayList<String> result){
    	
    }
    public static int reverseBits(int n) {
        int rst = 0;
        boolean signed = false;
        if ((n&1) == 1)
            signed = true;
        for (int i=0;i<32;i++){
            rst += n&1;
            n = n>>1;
            rst = rst << 1;
        }
        return rst;
    }
    public static void main(String[] argv){
    	int[] num = {1,2,3,4,5};
		ArrayBasic.reverse(num, 1, 4);
		ArrayBasic.showArray(num);
		System.out.println(reverseBits(43261596));
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i=0;i<=5;i++)
			q.add(i);
		System.out.println(-1%10);
		int[] a= new int[]{1};
//    	Herit parent = new Herit();
//    	Child child = new Child();
//    	Herit aa = new Child();
//    	parent.show();
//    	child.show();
//    	aa.show();
//		
//		int[] A = {1,2,3};
//		int B[] = {1,2,3,4};
//		System.out.println(A);
//		System.out.println(B);
//		System.out.println(B);
//		System.arraycopy(src, srcPos, dest, destPos, length);
//		int a=1, s=2;
//		ArrayList<Integer> rst = new ArrayList<Integer>();
//		rst.add(null);
//		rst.add(null);
//		String ss = " a";
//		System.out.println(ss.split(" ").length);
//		System.out.println(0104);
//		
//		
//		System.out.println(Integer.MIN_VALUE+"\n"+Integer.MAX_VALUE);
//		System.out.println(divide(Integer.MIN_VALUE, -1));
//		Helloworld test = new Helloworld();
//		char[][] board = {{..9748...},"7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
	}
	
	public static int divide(int dividend, int divisor) {
        if (divisor ==0)
            return Integer.MAX_VALUE;
        long rst =0;
        if (dividend == Integer.MIN_VALUE){
            rst += 1;
            dividend += Math.abs(divisor);
        }
        if (divisor == Integer.MIN_VALUE)
            return (int)rst;
        boolean sign = false;
        if (dividend < 0) 
            sign = !sign;
        if (divisor < 0) 
            sign = !sign;
        
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        
        while (a >= b){
            int shift =0;
            while (a >= (b<<shift)){
                shift++;
            }
            
            rst += (1 << (shift-1));
            a -= b<<(shift-1); 
        }
        
        
        return sign? (int)-rst : (int)rst;
    }

}


