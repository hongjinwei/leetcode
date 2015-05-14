/*
Factorial Trailing Zeroes Total Accepted: 23441 Total Submissions: 83472 My Submissions Question Solution 
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

@https://leetcode.com/problems/factorial-trailing-zeroes/
*/
import java.io.*;
import java.util.*;

public class Solution {

    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int ans = 0;
        long  t = 5;
        while( n >= t) {
        	ans += n/t;
        	t *= 5;
        }

        /*
        for(int i=5; i <= n; i = i+5){
        	int tmp = i;
        	while(tmp % 5 == 0){
        		ans++;
        		tmp = tmp / 5;
        	}
        }
        */
        return ans;
    }

    public int fact(int n){
    	if(n == 1) return 1;
    	return fact(n-1)*n;
    }

    public boolean verify(int n) {

    	int c = 0;
    	int a=1;
    	for(int i = 1; i <= n; i++){
    		a = a*i;
    		while(a % 10 == 0){
    			c++;
    			a = a / 10;
    		}
    	}

    	println(c);
    	return c==trailingZeroes(n);
    }
	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution(); 
    	println(s.trailingZeroes(30));   
    }
}