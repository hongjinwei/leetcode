//https://leetcode.com/problems/median-of-two-sorted-arrays/
//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

import java.io.*;
import java.util.*;

public class Solution {

	public boolean isOdd(int num)
	{
		return (num&1) == 1;
	}

	public int getKth(int a[],int b[], int k)
	{
		if (a.length > b.length) {
			return getKth(b,a,k);
		}

		if(a.length == 0){
			return b[k-1];
		}

		if(k == 1){
			return Math.min(a[0],b[0]);
		}
		int pa = Math.min(k/2,a.length), pb = k - pa;
		//System.out.println(pa + " " + pb);
		if(a[pa-1] == b[pb-1]){
			return a[pa-1];
		}else if(a[pa - 1] < b[pb - 1]){
			return getKth(Arrays.copyOfRange(a, pa, a.length),b, k-pa);
		}else{
			return getKth(a,Arrays.copyOfRange(b,pb,b.length),k-pb);
		}
	}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    	int total = nums1.length + nums2.length; // find the k's number

		if(isOdd(total)){
			//return getKth(nums1,0,nums2,0,k);
			return getKth(nums1,nums2,total/2+1);
		}else{
			//return (double)(getKth(nums1,0,nums2,0,k) + getKth(nums1,0,nums2,0,k+1))/2;
			return (double)(getKth(nums1,nums2,total/2) + getKth(nums1,nums2,total/2+1))/2;
		}
    }

    public static void main(String[] args)
    {
    	int[] a = {1};
    	int[] b = {1};
    	int[] c = new int[a.length+b.length];
    	int i =0 ;
    	for(int x:a){
    		c[i] = x;
    		i++;
    	}

    	for(int x:b){
    		c[i] = x;
    		i++;
    	}

    	Arrays.sort(c);
    	System.out.println(Arrays.toString(c));
    	//System.out.println(((c.length&1)==1)?c[c.length/2]:(c[c.length/2 - 1] + c[c.length/2])/2 );
    	Solution s = new Solution();
    	System.out.println(s.findMedianSortedArrays(a,b));
    	//System.out.println(s.getMedian(b,2,0,2));
    }
}