//https://leetcode.com/problems/median-of-two-sorted-arrays/
//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

import java.io.*;
import java.util.*;

public class Solution {

	public boolean isOdd(int l, int r)
	{
		return ((l-r)&1) == 0;
	}

	public double getMedian(int[] num, int l, int r)
	{
		if(l == r){
			return num[l];
		}else if(isOdd(l,r)){
			return num[(r+l) / 2];
		}else{
			return (double)(num[(r+l)/2] + num[(r+l)/2 + 1])/2;
		}
	}

	public double getMedian(int[] nums1, int[] nums2, int l1, int r1, int l2, int r2)
	{
		int size = r1-l1+2+r2-l2 ;
		int[] tmp = new int[size];
		System.arraycopy(nums1,l1,tmp,0,r1-l1+1);
		System.arraycopy(nums2,l2,tmp,r1-l1+1,r2-l2+1);
		Arrays.sort(tmp);
		
		if( (size&1) == 1){
			return tmp[size/2];
		}else{
			return (double)(tmp[size/2 - 1] + tmp[size/2])/2;
		}
	}
	
	public int getCut(int l, int r)
	{
		if(((r - l)&1) == 1){
			return (r-l)/2 + 1;
		}else{
			return (r-l)/2;
		}
	}

	public double process(int[] nums1, int[] nums2, int l1, int r1, int l2, int r2)
	{
		for(int i=l1;i<=r1;i++){
			System.out.print(nums1[i] + " ");
		}
		System.out.println();
		for(int i=l2;i<=r2;i++){
			System.out.print(nums2[i] + " ");
		}
		System.out.println("\n=======");
		if((r1-l1) <= 1 || (r2-l2) <= 1 ){
			return getMedian(nums1,nums2,l1,r1,l2,r2);
		}

		double median1 = getMedian(nums1, l1, r1);
		double median2 = getMedian(nums2, l2, r2);
		System.out.println("median1: " + median1 + " median2: "+ median2);
		if(median2 == median1){
			return median1;
		}else if(median1 < median2){
			int cut = Math.min( getCut(l1,r1), getCut(l2,r2) );
			return process(nums1, nums2, l1+cut,r1,l2,r2-cut);
		}else{
			int cut = Math.min( getCut(l1,r1), getCut(l2,r2) );
			return  process(nums1, nums2, l1, r1-cut, l2+cut, r2);
		}
	}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int l1 = 0;
    	int l2 = 0;
    	int r1 = nums1.length - 1;
    	int r2 = nums2.length - 1;

    	if(r1 == -1){
    		return getMedian(nums2,l2,r2);
    	}

    	if(r2 == -1){
    		return getMedian(nums1,l1,r1);
    	}

    	return process(nums1, nums2, l1, r1, l2, r2);   
    }

    public static void main(String[] args)
    {
    	int[] a = {1,2,6,7};
    	int[] b = {3,4,5,8};
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
    	System.out.println(((c.length&1)==1)?c[c.length/2]:(c[c.length/2 - 1] + c[c.length/2])/2 );
    	Solution s = new Solution();
    	System.out.println(s.findMedianSortedArrays(a,b));
    	//System.out.println(s.getMedian(b,2,0,2));
    }
}