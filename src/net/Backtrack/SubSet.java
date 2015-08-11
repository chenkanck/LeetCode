package net.Backtrack;

import java.util.*;

public class SubSet {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(ret, nums, 0 , list);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, int[] nums, int curIndex, List<Integer> list){
//        if (curIndex == nums.length){
//            ret.add(new ArrayList<Integer>(list));
//            return;
//        } 
    	// it can be commented
        ret.add(new ArrayList<Integer>(list));
        for (int i=curIndex; i< nums.length;i++){
            list.add(nums[i]);
            helper(ret, nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
