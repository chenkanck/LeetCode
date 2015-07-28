package net.stringAndArray;

public class MergeSortedArray88 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //new array
        int[] rst = new int[m+n];
        int cur = 0, i1 = 0, i2 = 0;
        while (cur < m+n && i1<m && i2<n){
            if (nums1[i1]<=nums2[i2]){
                rst[cur] = nums1[i1];
                i1++;
            }else{
                rst[cur] = nums2[i2];
                i2++;
            }
            cur++;
        }
        if (i1<m){
            // while(cur < m+n){
            //     rst[cur] = nums1[i1];
            //     cur++;
            //     i1++;
            // }
            System.arraycopy(nums1,i1, rst, cur, m-i1);
        }
        if (i2<n){
            // while (cur < m+n){
            //     rst[cur] = nums2[i2];
            //     cur++;
            //     i2++;
            // }
            System.arraycopy(nums2,i2, rst, cur,n-i2);
        }
//         nums1 = rst;    //copy?
        System.arraycopy(rst,0,nums1,0,m+n);
    }
	
	public void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {
        //in palce
        int cur = m+n-1, end1 = m-1, end2 = n-1;
        while(end1>=0 && end2>=0){
            if (nums1[end1] >= nums2[end2]){
                nums1[cur] = nums1[end1];
                end1--;
            }else{
                nums1[cur] = nums2[end2];
                end2--;
            }
            cur--;
        }
        if (end1<0) 
            System.arraycopy(nums2,0,nums1,0,end2+1);
        // else 
        //     System.arraycopy(nums1,0,nums1,0,end1+1);
        // dont have to copy nums1, its already there
    }
	
	public void mergeClean(int[] nums1, int m, int[] nums2, int n) {
        int cur = m+n-1, end1 = m-1, end2 = n-1;
        while(end1>=0 && end2>=0){
            nums1[cur--] = nums1[end1] >= nums2[end2]? nums1[end1--] : nums2[end2--];
        }
        if (end1<0) 
            System.arraycopy(nums2,0,nums1,0,end2+1);
    }
	
	public static void main(String[] args){
		int[] nums1 = {0};
		int[] nums2 = {1};
		merge(nums1,0,nums2,1);
	}
}
