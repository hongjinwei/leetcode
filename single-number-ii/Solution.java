/*
@https://leetcode.com/problems/single-number-ii/
Given an array of integers, 
every element appears three times except for one. 

Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

*/

import java.util.*;
import java.io.*;

public class Solution{

	public int singleNumber(int[] nums) {
        
		int[] bits = new int[32];
		int j = 0;
        for(int i=0; i<nums.length; i++){
        	j = 0;
        	while(nums[i] != 0){
        		bits[j] += nums[i] & 1;
        		j++;
        		nums[i] >>>= 1;
        	}
        	//System.out.println(Arrays.toString(bits) + " " + bits.length);
        }

        //System.out.println(" j: " + j);
        
        int res = 0;
        for(int k=31;k>=0;k--){
        	res = res<<1;
        	res = res | (bits[k] % 3);
        }
        //System.out.println(Integer.toBinaryString(res) + " " + Integer.toBinaryString(res).length());
        return res;
    }
	
	public static void main(String[] args){
		int[] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		Solution s = new Solution();
		System.out.println(s.singleNumber(nums));
		//System.out.println(Integer.toBinaryString(-4));
	}
}