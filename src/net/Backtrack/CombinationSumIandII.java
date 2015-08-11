package net.Backtrack;
import java.util.*;

public class CombinationSumIandII {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ret, sum, target, candidates, 0);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, List<Integer> sum, int target, int[] nums, int cur){
        if (target < 0 ) return ;
        if (target == 0){
            ret.add(new ArrayList<Integer>(sum));
            return ;
        }
        if (target < nums[cur] ) return;
        for (int i=cur; i<nums.length; i++){
            sum.add(nums[i]);
            helper(ret, sum, target-nums[i], nums, i);
            sum.remove(sum.size()-1);
        }
    }
	/**
	 * II with duplicate nums
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ret, sum ,candidates,target, 0);
        return ret;
    }
	// Compare with SubSetII
    public void helper(List<List<Integer>> ret,List<Integer> sum, int[] nums, int target, int start){
        if (target<0) return;
        if (target==0){
            ret.add(new ArrayList<Integer>(sum));
            return;
        }
        for (int i=start; i<nums.length;i++){
            // while (i!=start && nums[i] == nums[i-1]) i++;
            if (i!=start && nums[i] == nums[i-1]) continue;
            sum.add(nums[i]);
            helper(ret,sum,nums, target - nums[i], i+1);
            sum.remove(sum.size() -1);
            
        }
    }
}
