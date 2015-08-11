package net.Backtrack;
import java.util.*;

public class Combination {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<>();
        helper(ret, comb, n, k , 1);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret,List<Integer> comb, int n , int k, int start){
        if (k==0){
            ret.add( new ArrayList<Integer>(comb));
            return;
        }
        for (int i=start; i<=n ;i++){
            comb.add(i);
            helper(ret, comb, n , k-1, i+1);
            comb.remove(comb.size()-1);
        }
    }
}
