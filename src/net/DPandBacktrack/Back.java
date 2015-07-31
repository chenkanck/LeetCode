package net.DPandBacktrack;

import java.util.*;

public class Back {
	
	public int back (int target, Set<Integer> set){
		
		int[] dp = new int[target+1];
		Arrays.fill(dp, 0);
		for (int i = 1;i<=target;i++){
			int tmp = 0;
			for (int j: set)
					tmp += helper(i,j,dp);
			dp[i] = tmp;
		}
		return dp[target];
	}
	
	public int helper(int i,int j, int[] dp){
		if (i-j < 0)
			return 0;
		else if ( i==j)
			return 1;
		else
			return dp[i-j];
	}
}

class tests{
	public static void main(String[] args){
		Set<Integer> set = new HashSet<>(Arrays.asList(6,9,20));
		List<Integer> list = Arrays.asList(18,20,30,36);
		for (int t:list)
			System.out.println((new Back()).back(t, set));
		int[] ii = {1,2};
	}
}
