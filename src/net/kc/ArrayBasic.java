package net.kc;

public class ArrayBasic {
	public static void reverse (int[] num, int start, int end) {
		if (start >= end)
			return;
		for (int i=start, j=end; i<j ; i++, j--){
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
	}
	
	public static void showArray(int[] num){
		for (int i=0;i<num.length;i++){
			System.out.print(num[i]);
			if (i == num.length-1)
				System.out.print("\n");
			else
				System.out.print(",");
		}
	}
}
