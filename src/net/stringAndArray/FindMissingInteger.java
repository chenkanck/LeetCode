package net.stringAndArray;

public class FindMissingInteger {
	public static int findMissing(int[] nums) {
		int index = 0;
        while (index<nums.length){
            int tmp = nums[index];
            if (tmp<0 || tmp>=nums.length ||tmp == index) {
                index++;
                continue;
            }
            nums[index] = nums[tmp];
            nums[tmp] = tmp;
        }
        int i=0;
        for (;i<nums.length;i++)
            if(i != nums[i])
                break;
        return i;
        // int sum = 0;
        // for (int i:nums)
        //     sum+=i;
        // int rst = 0;
        // for (int i=0;i<=nums.length;i++)
        //     rst += i;
        // return rst-sum;
    }
	
	public static void main (String[] args){
		System.out.println(findMissing(new int[]{0}));
	}
}
