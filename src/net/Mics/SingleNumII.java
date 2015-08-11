package net.Mics;

public class SingleNumII {
	
	public int singleNumII(int[] nums){
		
		int one=0, two=0,three =0;
		for (int n : nums){
			int tmp= three;
			three = two&n;
			two = one & n;
			one = tmp & n;
		}
		return one;
	}
}
