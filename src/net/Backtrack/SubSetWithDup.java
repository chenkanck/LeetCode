package net.Backtrack;
import java.util.*;
public class SubSetWithDup {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        helper(ret, subset, nums, 0);
        return ret;
    }
    /*
     * Compare with Combination II
     */
    public void helper(List<List<Integer>> ret, List<Integer> path, int[] nums, int index){
        ret.add(new ArrayList<Integer>(path));
        for (int i=index; i<nums.length;i++){
            path.add(nums[i]);
            helper(ret, path, nums, i+1);
            while (i+1 < nums.length &&nums[i] == nums[i+1]) i++;
            path.remove(path.size()-1);
        }
    }
}
