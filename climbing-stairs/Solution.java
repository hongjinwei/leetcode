/*
Climbing Stairs Total Accepted: 51945 Total Submissions: 151667 My Submissions Question Solution 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

@https://leetcode.com/problems/climbing-stairs/
*/
import java.io.*;
import java.util.*;

/*
public class Solution {
    int count = 0;
    public void process(int n) {
        if(n == 0 || n == 1){
            count++;
        }else{
            process(n-1);
            process(n-2);
        }    
    }
    public int climbStairs(int n) {
        process(n);
        return count;
    }

	public static void println(Object obj) {
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	println(s.climbStairs(44));    
    }
}
*/
// this function cause a time limitation exceed



public class Solution {

    public int climbStairs(int n) {
    	if(n <= 0) return 0;
    	if(n == 1){
    		return 1;
    	}

        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for(int i=2;i<n;i++){
        	res[i] = res[i-1] + res[i-2];
        }

        return res[n-1];
    }

	public static void println(Object obj) {
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	println(s.climbStairs(44));    
    }
}
