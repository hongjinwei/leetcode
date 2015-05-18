/*
Minimum Size Subarray Sum Total Accepted: 2473 Total Submissions: 10826 My Submissions Question Solution 
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

@https://leetcode.com/problems/minimum-size-subarray-sum/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    public int minSubArrayLen(int s, int[] nums) {
    	
    	int len = nums.length;
    	if( len == 0) return 0;
    	int[] min = new int[len];
    	int ans = 0, i = 0, j = 1, sum = nums[0];

    	for(i = 0; i < len; i++){
    		if(nums[i] >= s) return 1;

    		min[i] = ( i == 0 )? 1 : min[i-1] - 1;		
    		
    		boolean moved = false;
    		for(;j < len; j++){
    			if(sum >= s) break;
    			moved = true;
    			min[i]++;
    			sum += nums[j];
    			if(sum >= s) break;
    		}
    		if( (min[i] < ans || ans == 0) && sum >= s ) ans = min[i];
    		sum = sum - nums[i];
    		if(moved) j++;
			if( j >= len && sum < s) {
			    //println(Arrays.toString(min));
			    return ans;
			}
    	}
    	//println(Arrays.toString(min));
    	return ans;
    }*/

    int ans;
    public void process(int i, int j, int[] nums, int s, int sum) {
    	if( (j >= nums.length-1 && sum < s) || i > j || i >= nums.length ) return ;

    	if(sum >= s) {
    		if(ans == 0 || (j-i+1) < ans) ans = j-i+1;
    		process(i+1, j, nums, s, sum - nums[i]); 
    	}else{
    		process(i, j+1, nums, s, sum + nums[j+1]);
    	}

    }

    public int minSubArrayLen(int s, int[] nums) {
    	ans = 0;
    	process(0,0,nums,s, nums[0]);
    	return ans;
    }

	public static void println(Object obj){
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] nums =  {2,3,1,2,4,3};
    	int t = 7;
    	println(s.minSubArrayLen(t, nums));    
    }
}