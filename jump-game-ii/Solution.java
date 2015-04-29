/*
Jump Game II Total Accepted: 35836 Total Submissions: 146966 My Submissions Question Solution 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

@https://leetcode.com/problems/jump-game-ii/
*/

import java.io.*;
import java.util.*;


public class Solution {
    
	public int jump(int[] nums) {
		int len = nums.length;
    	int[] least = new int[len];
 
    	System.out.println(Arrays.toString(least));
    	least[0] =0;
    	int i=0, j=0;
    	int steps = 0;
    	int max=0;
    	while(max<(len-1)){
    		for(int k=i;k<=j;k++){
    			max = Math.max(max, nums[k] + k);
    			if(max>=len-1){
    				return steps+1;
    			}
    		}

    		for(int k =j+1;k<=max && k<len;k++){
    			least[k] = steps+1;
    		}
    		steps++;
    		i = j+1;
    		j = max;
    		System.out.println(Arrays.toString(least));
    	}
    	  
    	return least[len-1];
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] n = {2,3,1,4,4};
    	System.out.println(s.jump(n));    
    }
}
