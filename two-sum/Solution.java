/*
Two Sum Total Accepted: 88695 Total Submissions: 503937 My Submissions Question Solution 
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

@https://leetcode.com/problems/two-sum/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
        	if(map.containsKey(nums[i])){
        		int[] res = new int[2];
        		res[0] = Math.min(map.get(nums[i]) ,i) + 1;
        		res[1] = Math.max(map.get(nums[i]), i) + 1;
        		return res;
        	}

        	map.put(target-nums[i],i);
        }
        return null;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] numbers = {0,3,2,0};
    	int target = 0;
    	println(Arrays.toString(s.twoSum(numbers, target)));    
    }
}