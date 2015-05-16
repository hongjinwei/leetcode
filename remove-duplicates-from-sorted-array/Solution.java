/*
Remove Duplicates from Sorted Array Total Accepted: 60577 Total Submissions: 192249 My Submissions Question Solution 
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length
@https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    public int removeDuplicates(int[] nums) {
        if( nums.length == 0 || nums.length == 1) return nums.length;

        int count = 1;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[i-1]){
                nums[count] = nums[i]; 
                count++;                   
            }

        }
        return count;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] k = {1,1,2,3};
    	println(s.removeDuplicates(k));    
        println(Arrays.toString(k));
    }
}